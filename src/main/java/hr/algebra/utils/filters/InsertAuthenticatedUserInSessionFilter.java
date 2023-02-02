package hr.algebra.utils.filters;


import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Basket;
import hr.algebra.models.User;
import hr.algebra.utils.exceptions.DataBaseException;
import hr.algebra.viewModel.BasketViewModel;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class InsertAuthenticatedUserInSessionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession session = request.getSession();
        String remoteUser = request.getRemoteUser();

        List<BasketViewModel> cart = (List<BasketViewModel>) session.getAttribute("cart");
        User user = (User) session.getAttribute("user");
        try {
            if (remoteUser != null && user == null && cart == null) {
                user = getUserData(remoteUser);
                cart = getUserBasket(user.getId());

                session.setAttribute("user", user);
                session.setAttribute("cart", cart);
            } else if (remoteUser != null && user == null && cart != null) {
                user = getUserData(remoteUser);
                List<BasketViewModel> cartFromDb = getUserBasket(user.getId());

                for (BasketViewModel b: cartFromDb) {
                    if (!cart.contains(b)){
                        cart.add(b);
                    }
                }

                session.setAttribute("user", user);
                session.setAttribute("cart", cart);
            } else if (user != null && cart == null) {
                cart = getUserBasket(user.getId());
                session.setAttribute("cart", cart);
            }
        } catch (DataBaseException e) {
            throw new RuntimeException(e);
        }

        chain.doFilter(request, res);
    }

    private static User getUserData(String remoteUser) throws DataBaseException {
        IUnitOfWork uow = RepoFactory.getUnitOfWork();
        return uow.users().getByEmail(remoteUser);
    }

    private List<BasketViewModel> getUserBasket(int userId) throws DataBaseException {
        IUnitOfWork uow = RepoFactory.getUnitOfWork();
        List<Basket> basket = uow.baskets().getAllItemsForUser(userId);
        List<BasketViewModel> basketViewModel = new ArrayList<>();

        for (Basket b : basket) {
            basketViewModel.add(b.toViewModel(true));
        }

        return basketViewModel;
    }
}
