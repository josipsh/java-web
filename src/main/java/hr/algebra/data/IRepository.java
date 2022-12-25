package hr.algebra.data;

import java.util.List;

public interface IRepository<T> {

    List<T> getAll();

    T getById(int id);

    void add(T entity);

    void edit(T entity);

    void delete(T entity);
}
