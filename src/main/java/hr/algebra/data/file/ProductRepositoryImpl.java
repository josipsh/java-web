package hr.algebra.data.file;

import hr.algebra.data.IProductRepository;
import hr.algebra.models.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class ProductRepositoryImpl implements IProductRepository {
    private final ArrayList<Product> products;

    public ProductRepositoryImpl() {
        products = FakeDatabase.getProducts();
    }

    @Override
    public List<Product> getAll() {
        return new ArrayList<>(products);
    }

    @Override
    public List<Product> getAllInCategory(String categoryLink) {
        return products
                .stream()
                .filter(x -> x.getSubcategory().getCategory().getLink().equals(categoryLink))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> getAllInSubcategory(String subcategoryLink) {
        return products
                .stream()
                .filter(x -> x.getSubcategory().getLink().equals(subcategoryLink))
                .collect(Collectors.toList());
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
                item.setSubcategoryId(entity.getSubcategoryId());
                item.setSubcategory(entity.getSubcategory());
            }
        }
    }

    @Override
    public void delete(Product entity) {
        products.remove(entity);
    }
}
