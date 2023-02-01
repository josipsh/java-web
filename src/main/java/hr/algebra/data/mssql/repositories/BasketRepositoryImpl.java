package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.Basket;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class BasketRepositoryImpl extends UnsafeRepository<Basket> implements IRepository<Basket> {
    @Override
    public List<Basket> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from Basket as b",
                Basket.class);
    }

    @Override
    public Basket getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from Basket as b where b.Id = ?",
                Basket.class,
                id);
    }
}
