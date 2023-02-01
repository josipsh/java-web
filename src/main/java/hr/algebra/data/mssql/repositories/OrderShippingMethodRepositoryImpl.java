package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.OrderShippingMethod;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public class OrderShippingMethodRepositoryImpl
        extends UnsafeRepository<OrderShippingMethod>
        implements IRepository<OrderShippingMethod> {
    @Override
    public List<OrderShippingMethod> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from OrderShippingMethod",
                OrderShippingMethod.class);
    }

    @Override
    public OrderShippingMethod getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from OrderShippingMethod where Id = ?",
                OrderShippingMethod.class,
                id);
    }
}
