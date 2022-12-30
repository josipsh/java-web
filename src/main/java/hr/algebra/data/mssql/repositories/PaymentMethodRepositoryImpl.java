package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.models.PaymentMethod;
import hr.algebra.utils.Exceptions.DataBaseException;

import java.util.List;

public class PaymentMethodRepositoryImpl extends UnsafeRepository<PaymentMethod> implements IRepository<PaymentMethod> {
    @Override
    public List<PaymentMethod> getAll() throws DataBaseException {
        return super.getAllHelper(
                "select * from PaymentMethod",
                PaymentMethod.class);
    }

    @Override
    public PaymentMethod getById(int id) throws DataBaseException {
        return super.getByIdHelper(
                "select * from PaymentMethod where Id = ?",
                PaymentMethod.class,
                id);
    }
}
