package hr.algebra.data.mssql.repositories;

import hr.algebra.data.IProductRepository;
import hr.algebra.data.mssql.SessionFactorySingleton;
import hr.algebra.models.Product;
import hr.algebra.utils.Exceptions.DataBaseException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import java.util.List;

public class ProductRepositoryImpl extends UnsafeRepository<Product> implements IProductRepository {
    @Override
    public List<Product> getAllInCategory(String categoryLink) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {p.*} from Product as p inner join Subcategory as s on p.SubcategoryId = s.Id inner join category as c on s.CategoryId = c.Id where c.Link = ?");
            query.addEntity("p", Product.class);
            query.setParameter(0, categoryLink);

            List<Product> result = query.list();

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
    public List<Product> getAllInSubcategory(String subcategoryLink) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {p.*} from Product as p inner join Subcategory as s on p.SubcategoryId = s.Id where s.Link = ?");
            query.addEntity("p", Product.class);
            query.setParameter(0, subcategoryLink);

            List<Product> result = query.list();

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
    public List<Product> getAll() throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {p.*} from Product as p");
            query.addEntity("p", Product.class);

            List<Product> result = query.list();

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
    public Product getById(int id) throws DataBaseException {
        Session session = SessionFactorySingleton.getSessionFactory().getCurrentSession();
        try {
            session.beginTransaction();

            SQLQuery query = session.createSQLQuery("select {p.*} from Product as p where p.Id = ?");
            query.addEntity("p", Product.class);
            query.setParameter(0, id);

            List<Product> result = query.list();
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
