package hr.algebra.data;

import hr.algebra.models.*;

public interface IUnitOfWork {
    IUserRepository users();

    IProductRepository products();

    IRepository<SubCategory> subCategories();

    IRepository<Category> categories();

    IBlobRepository blobRepository();

    IRepository<Basket> baskets();

    IRepository<Order> orders();

    IRepository<PaymentMethod> paymentMethods();

    IRepository<OrderShippingMethod> orderShippingMethods();

    IRepository<LoginRecord> loginRecords();
}
