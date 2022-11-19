package hr.algebra.data;

import java.util.Collection;
import java.util.List;

public interface IRepository<T> {

    Collection<T> getAll();

    T getById(int id);

    void add(T entity);

    void edit(T entity);

    void delete(T entity);
}
