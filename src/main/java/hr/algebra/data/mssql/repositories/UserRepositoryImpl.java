package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.data.mssql.SessionFactorySingleton;
import hr.algebra.models.User;
import hr.algebra.utils.Exceptions.DataBaseException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class UserRepositoryImpl extends UnsafeRepository<User> implements IRepository<User> {
    @Override
    public List<User> getAll() throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {u.*} from Users as u");
            query.addEntity("u", User.class);

            List<User> result = query.list();

            session.getTransaction().commit();
            return result;
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
    public User getById(int id) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {u.*} from Users as u where u.Id = ?");
            query.addEntity("u", User.class);
            query.setParameter(1, id);

            List<User> result = query.list();
            if (result.size() != 1){
                throw new DataBaseException("There is either too little or many records");
            }

            session.getTransaction().commit();
            return result.get(0);
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