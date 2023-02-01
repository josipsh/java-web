package hr.algebra.data;

import hr.algebra.utils.exceptions.DataBaseException;

import java.util.List;

public interface IRepository<T> extends IUnsafeRepository<T> {

    List<T> getAll() throws DataBaseException;

    T getById(int id) throws DataBaseException;
}
