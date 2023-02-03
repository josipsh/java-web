package hr.algebra.models;

import hr.algebra.viewModel.BasketViewModel;

public class Basket {
    private int id;
    private int quantity;
    private User user;
    private Product product;

    public Basket() {
    }

    public Basket(int id, int quantity, User user, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setUserIfNull(User user) {
        if (this.user == null) {
            this.user = user;
        }
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BasketViewModel toViewModel(boolean isSaved) {
        return new BasketViewModel(
                id,
                quantity,
                user,
                product,
                isSaved);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Basket){
            return  ((Basket) obj).getId() == id;
        }
        return false;
    }
}
