package hr.algebra.data.file;

import hr.algebra.models.Category;
import hr.algebra.models.Product;
import hr.algebra.models.SubCategory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FakeDatabase {
    private static final ArrayList<Category> categories = initCategories();
    private static final ArrayList<SubCategory> subCategories = initSubcategories();
    private static final ArrayList<Product> products = initProducts();

    public static void addProduct(Product product){
        products.add(product);
    }
    public static ArrayList<Product> getProducts(){
        return new ArrayList<>(products);
    }

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
        for (int i = 0; i < 5; i++) {
            Category cat = new Category(i, "Category " + i, "Category_" + i, new HashSet<>());
            _categories.add(cat);
        }

        return _categories;
    }
    private static ArrayList<SubCategory> initSubcategories(){
        ArrayList<SubCategory> _subCategories = new ArrayList<>();

        for (Category cat : categories) {
            Set<SubCategory> _sub = new HashSet<>();

            for (int i = 0; i < 10; i++) {
                SubCategory sub = new SubCategory(i, "SubCategory " + i, "SubCategory_" + i, cat.getId());
                sub.setCategory(cat);
                _sub.add(sub);
                _subCategories.add(sub);
            }

            cat.setSubcategories(_sub);
        }

        return _subCategories;
    }

    private static ArrayList<Product> initProducts() {
        ArrayList<Product> _products = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            Product prod = new Product();
            int subCatId = getRandomNumber(1, subCategories.size()) -1;

            prod.setId(i);
            prod.setTitle("Product " + i);
            prod.setDescription("Product description " + i);
            prod.setImageName(getImageName());
            prod.setPrice(i * 5.7f);
            prod.setSubcategoryId(subCatId);
            prod.setSubcategory(subCategories.get(subCatId));

            _products.add(prod);
        }

        return _products;
    }

    private static String getImageName() {
        int id = getRandomNumber(0, 3);
        if (id == 0){
            return "IMG_8201";
        }
        if (id == 1){
            return "IMG_8202";
        }
        if (id == 2){
            return "IMG_8206";
        }

        return "IMG_8221";
    }

    private static int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
