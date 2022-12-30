package hr.algebra.models;

import java.util.Set;

public class Category {
    private int id;
    private String displayName;
    private String link;
    private Set<SubCategory> subcategories;

    public Category() {
    }

    public Category(int id, String displayName, String link, Set<SubCategory> subcategories) {
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

    public Set<SubCategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<SubCategory> subcategories) {
        this.subcategories = subcategories;
    }
}
