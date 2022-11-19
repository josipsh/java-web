package hr.algebra.models;

public class Product {
    private int id;
    private String title;
    private String description;
    private float price;
    private SubCategory subcategory;

    public Product() {
    }

    public Product(int id, String title, String description, float price, SubCategory subcategory) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.price = price;
        this.subcategory = subcategory;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }
}
