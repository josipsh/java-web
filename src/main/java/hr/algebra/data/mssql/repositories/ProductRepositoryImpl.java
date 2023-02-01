package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IProductRepository;
import hr.algebra.models.Product;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class ProductRepositoryImpl extends UnsafeRepository<Product> implements IProductRepository {
    @Override
    public List<Product> getAllInCategory(String categoryLink) throws DataBaseException {
        return super.getAllHelper(
                "select * from Product as p " +
                            "inner join Subcategory as s on p.SubcategoryId = s.Id " +
                            "inner join category as c on s.CategoryId = c.Id where c.Link = ?",
                Product.class,
                categoryLink);
    }

    @Override
    public List<Product> getAllInSubcategory(String subcategoryLink) throws DataBaseException {
        return super.getAllHelper(
                "select * from Product as p " +
                            "inner join Subcategory as s on p.SubcategoryId = s.Id where s.Link = ?",
                Product.class,
                subcategoryLink);
    }

    @Override
    public List<Product> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from Product",
                Product.class);
    }

    @Override
    public Product getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from Product where Id = ?",
                Product.class,
                id);
    }
}
