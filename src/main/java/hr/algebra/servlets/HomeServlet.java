package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Product;
import hr.algebra.utils.exceptions.DataBaseException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private IUnitOfWork uow;

    @Override
    public void init() throws ServletException {
        super.init();
        uow = RepoFactory.getUnitOfWork();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String category = req.getParameter("category");
        String subcategory = req.getParameter("subcategory");

        List<Product> products;
        try {
            products = fetchProducts(category, subcategory);
        } catch (DataBaseException e) {
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        req.getSession().setAttribute("products", products);
        res.setContentType("text/html");

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/HomePage.jsp");
        requestDispatcher.forward(req, res);
    }

    private List<Product> fetchProducts(String category, String subcategory) throws DataBaseException {
        if (category != null && subcategory == null) {
            // filter by category
            return uow.products().getAllInCategory(category);
        } else if (category == null && subcategory != null) {
            // filter by subcategory
            return uow.products().getAllInSubcategory(subcategory);
        }
        return uow.products().getAll();
    }
}
