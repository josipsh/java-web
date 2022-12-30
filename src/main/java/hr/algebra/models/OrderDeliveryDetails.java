package hr.algebra.models;

public class OrderDeliveryDetails {
    private int id;
    private String streetAddress;
    private String city;
    private String zipcode;

    public OrderDeliveryDetails() {
    }

    public int getId() {
        return id;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
}
