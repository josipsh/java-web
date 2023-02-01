package hr.algebra.utils.filters;


import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.User;
import hr.algebra.utils.exceptions.DataBaseException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class InsertAuthenticatedUserInSessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        String remoteUser = request.getRemoteUser();

        if (remoteUser != null) {
            HttpSession session = request.getSession();

            if (session.getAttribute("user") == null) {
                try {
                    IUnitOfWork uow = RepoFactory.getUnitOfWork();
                    User user = uow.users().getByEmail(remoteUser);
                    session.setAttribute("user", user);
                } catch (DataBaseException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        chain.doFilter(req, res);
    }
}
