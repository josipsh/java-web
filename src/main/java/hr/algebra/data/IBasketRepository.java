package hr.algebra.data;

import hr.algebra.models.Basket;
import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public interface IBasketRepository extends IRepository<Basket> {
    List<Basket> getAllItemsForUser(int userId) throws DataBaseException;
}
