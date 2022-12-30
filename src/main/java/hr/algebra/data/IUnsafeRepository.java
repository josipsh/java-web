package hr.algebra.data;

import hr.algebra.utils.Exceptions.DataBaseException;

public interface IUnsafeRepository<T> {

    void add(T entity) throws DataBaseException;

    void edit(T entity) throws DataBaseException;

    void delete(T entity) throws DataBaseException;
}
