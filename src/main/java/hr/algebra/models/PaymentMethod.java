package hr.algebra.models;

public class PaymentMethod {
    private int id;
    private String type;

    public PaymentMethod() {
    }

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }
}
