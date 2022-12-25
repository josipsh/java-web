package hr.algebra.models;

public class SubCategory {
    private int id;
    private String displayName;
    private String link;
    private int categoryId;

    private Category category;

    public SubCategory() {
    }

    public SubCategory(int id, String displayName, String link, int categoryId) {
        this.id = id;
        this.displayName = displayName;
        this.link = link;
        this.categoryId = categoryId;
    }

    public int getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getLink() {
        return link;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public Category getCategory() {
        return category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
