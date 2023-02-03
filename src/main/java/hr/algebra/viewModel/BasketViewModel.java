package hr.algebra.viewModel;

import hr.algebra.models.Basket;
import hr.algebra.models.Product;
import hr.algebra.models.User;

public class BasketViewModel extends Basket {
    private boolean isSaved;

    public BasketViewModel(int id, int quantity, User user, Product product, boolean isSaved) {
        super(id, quantity, user, product);
        this.isSaved = isSaved;
    }

    public boolean isSaved() {
        return isSaved;
    }

    public void setSaved(boolean saved) {
        isSaved = saved;
    }

    public Basket toModel(){
        return new Basket(
                getId(),
                getQuantity(),
                getUser(),
                getProduct());
    }
}
