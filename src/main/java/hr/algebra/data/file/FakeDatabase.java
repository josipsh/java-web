package hr.algebra.data.file;

import hr.algebra.models.Category;
import hr.algebra.models.SubCategory;

import java.util.ArrayList;

public class FakeDatabase {
    private static final ArrayList<Category> categories = initCategories();
    private static final ArrayList<SubCategory> subCategories = initSubcategories();

    public static void addCategory(Category category){
        categories.add(category);
    }
    public static ArrayList<Category> getCategories(){
        return new ArrayList<>(categories);
    }
    public static void addSubcategory(SubCategory subcategory){
        subCategories.add(subcategory);
    }
    public static ArrayList<SubCategory> getSubcategories(){
        return new ArrayList<>(subCategories);
    }

    private static ArrayList<Category> initCategories(){
        ArrayList<Category> _categories = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Category cat = new Category(i, "Category " + i, "Category_" + i, new ArrayList<>());
            _categories.add(cat);
        }

        return _categories;
    }
    private static ArrayList<SubCategory> initSubcategories(){
        ArrayList<SubCategory> _subCategories = new ArrayList<>();

        for (Category cat : categories) {
            ArrayList<SubCategory> _sub = new ArrayList<>();

            for (int i = 0; i < 10; i++) {
                SubCategory sub = new SubCategory(i, "SubCategory " + i, "SubCategory_" + i, cat.getId());
                _sub.add(sub);
                _subCategories.add(sub);
            }

            cat.setSubcategories(_sub);
        }

        return _subCategories;
    }
}
