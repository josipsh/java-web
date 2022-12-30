package hr.algebra.models;

public class OrderShippingDetails extends OrderDeliveryDetails {
    private String collectorFirstName;
    private String collectorLastName;
    private String collectorPhoneNumber;
    private OrderShippingMethod shippingMethod;

    public OrderShippingDetails() {
    }

    public String getCollectorFirstName() {
        return collectorFirstName;
    }

    public String getCollectorLastName() {
        return collectorLastName;
    }

    public String getCollectorPhoneNumber() {
        return collectorPhoneNumber;
    }

    public OrderShippingMethod getShippingMethod() {
        return shippingMethod;
    }

    public void setCollectorFirstName(String collectorFirstName) {
        this.collectorFirstName = collectorFirstName;
    }

    public void setCollectorLastName(String collectorLastName) {
        this.collectorLastName = collectorLastName;
    }

    public void setCollectorPhoneNumber(String collectorPhoneNumber) {
        this.collectorPhoneNumber = collectorPhoneNumber;
    }

    public void setShippingMethod(OrderShippingMethod shippingMethod) {
        this.shippingMethod = shippingMethod;
    }
}
