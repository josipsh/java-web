package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Product;
import hr.algebra.utils.exceptions.DataBaseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", value = "/product")
public class ProductServlet extends HttpServlet {
    private IUnitOfWork uow;

    @Override
    public void init() throws ServletException {
        super.init();

        uow = RepoFactory.getUnitOfWork();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String productIdString = req.getParameter("productId");
        if (productIdString == null){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        int productId = parseProductId(productIdString);
        if (productId < 0){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        Product product = null;
        try {
            product = uow.products().getById(productId);
        } catch (DataBaseException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

        req.getSession().setAttribute("product", product);
        res.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/ProductPage.jsp");
        requestDispatcher.forward(req, res);
    }

    private static int parseProductId(String productIdString) {
        try {
            return Integer.parseInt(productIdString);
        }catch (NumberFormatException ex){
            return -1;
        }

    }
}
