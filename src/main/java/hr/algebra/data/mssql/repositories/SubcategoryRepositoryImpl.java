package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.SubCategory;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class SubcategoryRepositoryImpl extends UnsafeRepository<SubCategory> implements IRepository<SubCategory> {
    @Override
    public List<SubCategory> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from Subcategory",
                SubCategory.class);
    }

    @Override
    public SubCategory getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from Subcategory as s where s.Id = ?",
                SubCategory.class,
                id);
    }

}
