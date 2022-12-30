package hr.algebra.data;

import hr.algebra.models.Product;
import hr.algebra.utils.Exceptions.DataBaseException;

import java.util.List;

public interface IProductRepository extends IRepository<Product> {
    List<Product> getAllInCategory(String categoryLink) throws DataBaseException;
    List<Product> getAllInSubcategory(String subcategoryLink) throws DataBaseException;
}
