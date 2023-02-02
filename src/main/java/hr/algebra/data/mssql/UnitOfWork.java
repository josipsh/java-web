package hr.algebra.data.mssql;

import hr.algebra.data.*;
import hr.algebra.data.mssql.repositories.*;
import hr.algebra.models.*;

public class UnitOfWork  implements IUnitOfWork {
    @Override
    public IUserRepository users() {
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
    public IBasketRepository baskets() {
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

    @Override
    public IRepository<LoginRecord> loginRecords() {
        return new LoginRecordRepositoryImpl();
    }
}
