package hr.algebra.data;

import hr.algebra.models.User;

public interface IUnitOfWork {
    IRepository<User> users();
}
