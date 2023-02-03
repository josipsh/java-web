package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Product;
import hr.algebra.utils.exceptions.DataBaseException;
import hr.algebra.utils.helpers.RouteParameterHelper;
import hr.algebra.viewModel.BasketViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "CartServlet", value = "/cart")
public class CartServlet extends HttpServlet {

    private IUnitOfWork uow;

    @Override
    public void init() throws ServletException {
        super.init();
        uow = RepoFactory.getUnitOfWork();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/CartPage.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        int productId = RouteParameterHelper.getIntParameter(req, "productId");
        int quantity = RouteParameterHelper.getIntParameter(req, "quantity");

        List<BasketViewModel> cart = (List<BasketViewModel>) req.getSession().getAttribute("cart");
        if (cart == null) {
            cart = new ArrayList<>();
        }

        try {
            Product product = uow.products().getById(productId);
            cart.add(new BasketViewModel(cart.size() + 1, quantity, null, product, false));
            req.getSession().setAttribute("cart", cart);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse res) {
        int basketId = RouteParameterHelper.getIntParameter(req, "basketId");
        List<BasketViewModel> cart = (List<BasketViewModel>) req.getSession().getAttribute("cart");
        if (cart == null) {
            return;
        }

        Optional<BasketViewModel> basketItem = cart.stream().filter(x -> x.getId() == basketId).findFirst();
        if (basketItem.isPresent()){
            cart.remove(basketItem.get());
            req.getSession().setAttribute("cart", cart);
        }
    }
}
