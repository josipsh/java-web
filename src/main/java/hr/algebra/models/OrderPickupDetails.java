package hr.algebra.models;

public class OrderPickupDetails extends OrderDeliveryDetails {
    private String shopName;

    public OrderPickupDetails() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
