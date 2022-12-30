package hr.algebra.models;

import java.util.Set;

public class Order {
    private int id;
    private User user;
    private PaymentMethod paymentMethod;
    private OrderDeliveryDetails deliveryDetails;
    private Set<Product> products;

    public Order() {
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public OrderDeliveryDetails getDeliveryDetails() {
        return deliveryDetails;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDeliveryDetails(OrderDeliveryDetails deliveryDetails) {
        this.deliveryDetails = deliveryDetails;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
