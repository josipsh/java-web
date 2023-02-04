package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.*;
import hr.algebra.utils.exceptions.DataBaseException;
import hr.algebra.utils.helpers.RouteParameterHelper;
import hr.algebra.viewModel.BasketViewModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "OrderServlet", value = "/checkout")
public class OrderServlet extends HttpServlet {
    private IUnitOfWork uow;

    @Override
    public void init() throws ServletException {
        super.init();

        uow = RepoFactory.getUnitOfWork();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        try {
            List<PaymentMethod> paymentMethods = uow.paymentMethods().getAll();
            req.getSession().setAttribute("paymentMethods", paymentMethods);
        } catch (DataBaseException e) {
            throw new RuntimeException(e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/OrderPage.jsp");
        requestDispatcher.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            boolean isUserPickingUp = RouteParameterHelper.getBooleanParameter(req, "isUserPickingUp");
            int paymentMethodId = RouteParameterHelper.getIntParameter(req, "payment-method");
            int storeId = RouteParameterHelper.getIntParameter(req, "store");

            Set<Product> basket = getBasketProducts(req.getSession());
            User user = getUser(req.getSession());
            PaymentMethod paymentMethod = uow.paymentMethods().getById(paymentMethodId);
            OrderPickupDetails orderDeliveryDetails = getDeliveryDetails(req, isUserPickingUp, storeId);

            Order order = new Order();
            order.setPaymentMethod(paymentMethod);
            order.setUser(user);
            order.setProducts(basket);
            order.setDeliveryDetails(orderDeliveryDetails);

            uow.orders().add(order);
            req.getSession().setAttribute("cart", new ArrayList<BasketViewModel>());
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/HomePage.jsp");
        requestDispatcher.forward(req, res);
    }

    private Set<Product> getBasketProducts(HttpSession session) {
        List<BasketViewModel> cart = (List<BasketViewModel>) session.getAttribute("cart");
        if (cart == null || cart.size() == 0) {
            throw new RuntimeException();
        }

        List<Product> products = new ArrayList<>();

        for (BasketViewModel b : cart) {
            products.add(b.toModel().getProduct());
        }

        return new HashSet<>(products);
    }

    private User getUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            throw new RuntimeException();
        }

        return user;
    }

    private OrderPickupDetails getDeliveryDetails(HttpServletRequest req, boolean isUserPickingUp, int storeId) {
        if (!isUserPickingUp){
            throw new RuntimeException();
        }

        List<OrderPickupDetails> details = (List<OrderPickupDetails>) req.getSession().getAttribute("orderPickupDetails");
        Optional<OrderPickupDetails> store = details.stream().filter(x -> x.getId() == storeId).findFirst();
        if (!store.isPresent()){
            throw new RuntimeException();
        }

        return store.get();
    }

}
