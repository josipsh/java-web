package hr.algebra.data;

import hr.algebra.models.Product;

import java.util.List;

public interface IProductRepository extends IRepository<Product> {
    List<Product> getAllInCategory(String categoryLink);
    List<Product> getAllInSubcategory(String subcategoryLink);
}
