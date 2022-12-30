package hr.algebra.models;

public class Basket {
    private int id;
    private int quantity;
    private User user;
    private Product product;

    public Basket() {
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

    public void setProduct(Product product) {
        this.product = product;
    }
}
