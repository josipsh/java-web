package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IRepository;
import hr.algebra.data.mssql.SessionFactorySingleton;
import hr.algebra.models.Category;
import hr.algebra.models.SubCategory;
import hr.algebra.utils.Exceptions.DataBaseException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import java.util.List;

public class SubcategoryRepositoryImpl extends UnsafeRepository<SubCategory> implements IRepository<SubCategory> {
    @Override
    public List<SubCategory> getAll() throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {s.*} from Subcategory as s");
            query.addEntity("s", Category.class);

            List<SubCategory> result = query.list();

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
    public SubCategory getById(int id) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {s.*} from Subcategory as s where s.Id = ?");
            query.addEntity("s", Category.class);
            query.setParameter(0, id);

            List<SubCategory> result = query.list();
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
