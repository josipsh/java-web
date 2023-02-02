package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IBasketRepository;
import hr.algebra.models.Basket;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class BasketRepositoryImpl extends UnsafeRepository<Basket> implements IBasketRepository {
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

    @Override
    public List<Basket> getAllItemsForUser(int userId) throws DataBaseException {
        return super.getAllHelper(
                "select * from Basket as b inner join Users as u on b.UserId = u.Id where u.Id = ?",
                Basket.class,
                String.valueOf(userId));
    }
}
