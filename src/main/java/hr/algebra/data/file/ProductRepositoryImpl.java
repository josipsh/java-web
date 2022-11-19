package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.models.Category;
import hr.algebra.models.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class ProductRepositoryImpl implements IRepository<Product> {
    private final ArrayList<Product> products;

    public ProductRepositoryImpl() {
        products = new ArrayList<>();
        SubCategoryRepositoryImpl subCategoryRepo = new SubCategoryRepositoryImpl();

        for (int i = 0; i < 10; i++) {
            Product prod = new Product();

            prod.setId(i);
            prod.setTitle("Product " + i);
            prod.setDescription("Product description " + i);
            prod.setPrice(i * 5.6f);
            prod.setSubcategory(subCategoryRepo.getById(i));

            products.add(prod);
        }
    }

    @Override
    public Collection<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public Product getById(int id) {
        Optional<Product> prod = products.stream().filter(x -> x.getId() == id).findFirst();
        return prod.orElseGet(() -> products.get(0));
    }

    @Override
    public void add(Product entity) {
        products.add(entity);
    }

    @Override
    public void edit(Product entity) {
        for (Product item : products) {
            if (item.getId() == entity.getId()) {
                item.setTitle(entity.getTitle());
                item.setDescription(entity.getDescription());
                item.setPrice(entity.getPrice());
                item.setSubcategory(entity.getSubcategory());
            }
        }
    }

    @Override
    public void delete(Product entity) {
        products.remove(entity);
    }
}
