package hr.algebra.data.mssql;

import hr.algebra.data.*;
import hr.algebra.data.mssql.repositories.*;
import hr.algebra.models.*;
import hr.algebra.data.file.BlobRepository;

public class UnitOfWork  implements IUnitOfWork {
    @Override
    public IRepository<User> users() {
        return new UserRepositoryImpl();
    }

    @Override
    public IProductRepository products() {
        return new ProductRepositoryImpl();
    }

    @Override
    public IRepository<SubCategory> subCategories() { return new SubcategoryRepositoryImpl(); }

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
        return new BasketRepositoryImpl();
    }

    @Override
    public IRepository<Order> orders() {
        return new OrderRepositoryImpl();
    }

    @Override
    public IRepository<PaymentMethod> paymentMethods() {
        return new PaymentMethodRepositoryImpl();
    }

    @Override
    public IRepository<OrderShippingMethod> orderShippingMethods() {
        return new OrderShippingMethodRepositoryImpl();
    }
}
