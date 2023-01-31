package hr.algebra.data.file;

import hr.algebra.data.*;
import hr.algebra.models.*;

public class UnitOfWork implements IUnitOfWork {

    @Override
    public IUserRepository users() {
        return null;
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

    @Override
    public IRepository<LoginRecord> loginRecords() {
        return null;
    }
}
