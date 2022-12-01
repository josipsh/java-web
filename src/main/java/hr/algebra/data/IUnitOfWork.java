package hr.algebra.data;

import hr.algebra.models.Category;
import hr.algebra.models.Product;
import hr.algebra.models.SubCategory;
import hr.algebra.models.User;

import java.io.IOException;

public interface IUnitOfWork {
    IRepository<User> users();

    IRepository<Product> products();

    IRepository<SubCategory> subCategories();

    IRepository<Category> categories();

    IBlobRepository blobs() throws IOException;
}
