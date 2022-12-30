package hr.algebra.data.file;

import hr.algebra.data.IBlobRepository;
import hr.algebra.data.IProductRepository;
import hr.algebra.data.IRepository;
import hr.algebra.data.IUnitOfWork;
import hr.algebra.models.*;

public class UnitOfWork implements IUnitOfWork {

    @Override
    public IRepository<User> users() {
        return new UserRepositoryImpl();
    }

    @Override
    public IProductRepository products() {
        return new ProductRepositoryImpl();
    }

    @Override
    public IRepository<SubCategory> subCategories() {
        return new SubCategoryRepositoryImpl();
    }

    @Override
    public IRepository<Category> categories() {
        return new CategoryRepositoryImpl();
    }

    @Override
    public IBlobRepository blobRepository() {
        return new BlobRepository();
    }

    @Override
    public IRepository<Basket> baskets() {
        return null;
    }

    @Override
    public IRepository<Order> orders() {
        return null;
    }

    @Override
    public IRepository<PaymentMethod> paymentMethods() {
        return null;
    }

    @Override
    public IRepository<OrderShippingMethod> orderShippingMethods() {
        return null;
    }
}
