package hr.algebra.data;

import hr.algebra.models.User;
import hr.algebra.utils.Exceptions.DataBaseException;

public interface IUserRepository extends IRepository<User> {
    User getByEmail(String email) throws DataBaseException;
}
