package hr.algebra.servlets;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.User;
import hr.algebra.utils.Exceptions.DataBaseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthServlet", value = "/auth/*")
public class AuthServlet extends HttpServlet {

    private IUnitOfWork uow;
    @Override
    public void init() throws ServletException {
        super.init();

        uow = RepoFactory.getUnitOfWork();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        if(isLogOut(req.getRequestURI())){
            req.getSession().invalidate();
        }

        res.sendRedirect(getReturnLink(req));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        try {
            if (isLogin(req.getRequestURI())) {
                login(req);
            } else if (isRegister(req.getRequestURI())) {
                register(req);
            } else if (isLogOut(req.getRequestURI())) {
                req.getSession().invalidate();
            } else {
                res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                return;
            }
        }catch (DataBaseException ex){
            res.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return;
        }

        res.sendRedirect(getReturnLink(req));
    }

    private void login(HttpServletRequest req) {
        User user = new User();
        user.setEmail(req.getParameter("email"));

        req.getSession().setAttribute("user", user);
    }

    private void register(HttpServletRequest req) throws DataBaseException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        user.setEmail(req.getParameter("email"));

        uow.users().add(user);
    }

    private String getReturnLink(HttpServletRequest req) {
        String returnPage = req.getParameter("returnPage");
        if(returnPage != null){
            return returnPage;
        }

        return req.getContextPath();
    }

    private boolean isLogin(String requestUri) {
        String[] uris = requestUri.split("/");
        return uris[uris.length - 1].equals("login");
    }

    private boolean isRegister(String requestUri) {
        String[] uris = requestUri.split("/");
        return uris[uris.length - 1].equals("register");
    }

    private boolean isLogOut(String requestUri) {
        String[] uris = requestUri.split("/");
        return uris[uris.length - 1].equals("logout");
    }

}
