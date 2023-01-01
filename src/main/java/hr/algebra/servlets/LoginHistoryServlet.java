package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.LoginRecord;
import hr.algebra.utils.Exceptions.DataBaseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "LoginHistoryServlet", value = "/login-history")
public class LoginHistoryServlet extends HttpServlet {
    private IUnitOfWork uow;

    @Override
    public void init() throws ServletException {
        super.init();
        uow = RepoFactory.getUnitOfWork();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");

        try {
            List<LoginRecord> records = uow.loginRecords().getAll();
            req.getSession().setAttribute("loginRecords", records);
        }catch (DataBaseException exception){
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("Pages/LoginHistoryPage.jsp");
        requestDispatcher.forward(req, res);
    }
}
