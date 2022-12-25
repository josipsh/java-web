package hr.algebra.models;

import java.util.List;

public class Category {
    private int id;
    private String displayName;
    private String link;
    private List<SubCategory> subcategories;

    public Category() {
    }

    public Category(int id, String displayName, String link, List<SubCategory> subcategories) {
        this.id = id;
        this.displayName = displayName;
        this.link = link;
        this.subcategories = subcategories;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public List<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }
}
