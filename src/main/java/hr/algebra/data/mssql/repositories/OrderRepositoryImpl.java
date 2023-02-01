package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.Order;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class OrderRepositoryImpl extends UnsafeRepository<Order> implements IRepository<Order> {
    @Override
    public List<Order> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from Orders",
                Order.class);
    }

    @Override
    public Order getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from Orders where Id = ?",
                Order.class,
                id);
    }
}
