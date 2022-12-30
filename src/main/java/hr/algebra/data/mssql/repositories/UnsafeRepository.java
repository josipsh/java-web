package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IUnsafeRepository;
import hr.algebra.data.mssql.SessionFactorySingleton;
import hr.algebra.utils.Exceptions.DataBaseException;
import org.hibernate.Session;

public class UnsafeRepository<T> implements IUnsafeRepository<T> {
    @Override
    public void add(T entity) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.save(entity);

            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            throw new DataBaseException("An Error occurred", ex);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void edit(T entity) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.update(entity);

            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            throw new DataBaseException("An Error occurred", ex);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public void delete(T entity) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            session.delete(entity);

            session.getTransaction().commit();
        } catch (Throwable ex) {
            session.getTransaction().rollback();
            throw new DataBaseException("An Error occurred", ex);
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }
}
