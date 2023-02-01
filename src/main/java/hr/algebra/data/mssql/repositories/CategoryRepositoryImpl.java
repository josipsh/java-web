package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.Category;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class CategoryRepositoryImpl extends UnsafeRepository<Category> implements IRepository<Category> {
    @Override
    public List<Category> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from Category as c",
                Category.class);
    }

    @Override
    public Category getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from Category as c where c.Id = ?",
                Category.class,
                id);
    }
}
