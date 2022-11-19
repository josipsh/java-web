package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.data.IUnitOfWork;
import hr.algebra.models.User;

public class UnitOfWork implements IUnitOfWork {

    @Override
    public IRepository<User> users() {
        return new UserRepositoryImpl();
    }
}
