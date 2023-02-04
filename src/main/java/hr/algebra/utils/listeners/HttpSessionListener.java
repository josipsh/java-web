package hr.algebra.utils.listeners;

import hr.algebra.data.IUnitOfWork;
import hr.algebra.data.RepoFactory;
import hr.algebra.models.Basket;
import hr.algebra.models.OrderPickupDetails;
import hr.algebra.models.User;
import hr.algebra.utils.exceptions.DataBaseException;
import hr.algebra.viewModel.BasketViewModel;
import javax.servlet.http.HttpSessionEvent;
import java.util.ArrayList;
import java.util.List;

public class HttpSessionListener implements javax.servlet.http.HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        List<OrderPickupDetails> details = new ArrayList<>();

        details.add(getOrderDelivery(1,"Ilica 456", "Zagreb", "10 000", "MojShop - Ilica"));
        details.add(getOrderDelivery(2,"Branimirova 456", "Zagreb", "10 000", "MojShop - Branimirova"));
        details.add(getOrderDelivery(3,"Avenija Dubrovnik 456", "Zagreb", "10 000", "MojShop - Avenija Dubrovnik"));

        se.getSession().setAttribute("orderPickupDetails", details);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        List<BasketViewModel> cart = (List<BasketViewModel>) se.getSession().getAttribute("cart");
        User user = (User) se.getSession().getAttribute("user");
        if (cart == null || user == null) {
            return;
        }

        try {
            IUnitOfWork uow = RepoFactory.getUnitOfWork();
            List<Basket> cartFromDb = uow.baskets().getAllItemsForUser(user.getId());

            for (BasketViewModel b : cart) {
                b.setUserIfNull(user);

                if (cartFromDb.contains(b)){
                    uow.baskets().edit(b.toModel());
                    cartFromDb.remove(b.toModel());
                    continue;
                }

                if (!b.isSaved()){
                    uow.baskets().add(b.toModel());
                }
            }

            deleteRemovedCartItems(cartFromDb);
        } catch (DataBaseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void deleteRemovedCartItems(List<Basket> cart) throws DataBaseException {
        IUnitOfWork uow = RepoFactory.getUnitOfWork();
        for (Basket b: cart) {
            uow.baskets().delete(b);
        }
    }

    private OrderPickupDetails getOrderDelivery(int id,String address, String city, String zipcode, String shopName) {
        OrderPickupDetails delivery = new OrderPickupDetails();

        delivery.setId(id);
        delivery.setStreetAddress(address);
        delivery.setCity(city);
        delivery.setZipcode(zipcode);
        delivery.setShopName(shopName);

        return delivery;
    }

}
