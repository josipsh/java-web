package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.data.mssql.SessionFactorySingleton;
import hr.algebra.models.Category;
import hr.algebra.utils.Exceptions.DataBaseException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.util.List;

public class CategoryRepositoryImpl extends UnsafeRepository<Category> implements IRepository<Category> {
    @Override
    public List<Category> getAll() throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {c.*} from Category as c");
            query.addEntity("c", Category.class);

            List<Category> result = query.list();

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
    public Category getById(int id) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {c.*} from Category as c where c.Id = ?");
            query.addEntity("c", Category.class);
            query.setParameter(1, id);

            List<Category> result = query.list();
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
