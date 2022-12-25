package hr.algebra.models;

public class Product {
    private int id;
    private String title;
    private String description;
    private String imageName;
    private float price;
    private int subcategoryId;
    private SubCategory subcategory;

    public Product() {
    }

    public Product(int id, String title, String description, String imageName, float price, int subcategoryId) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageName = imageName;
        this.price = price;
        this.subcategoryId = subcategoryId;
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

    public String getImageName() {
        return imageName;
    }

    public float getPrice() {
        return price;
    }

    public int getSubcategoryId() {
        return subcategoryId;
    }

    public SubCategory getSubcategory() { return subcategory; }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setSubcategoryId(int subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }
}
