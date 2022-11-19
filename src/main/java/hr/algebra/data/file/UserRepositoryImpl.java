package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.models.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserRepositoryImpl implements IRepository<User> {

    private final List<User> users;

    public UserRepositoryImpl() {
        users = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setFirstName("Pero" + i);
            user.setLastName("Peric" + i);
            user.setEmail("pero" + i + ".peric@gmail.com");

            users.add(user);
        }
    }

    @Override
    public Collection<User> getAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User getById(int id) {
        return users.get(0);
    }

    @Override
    public void add(User entity) {
        users.add(entity);
    }

    @Override
    public void edit(User entity) {
        for (User user : users) {
            if (user.getId() == entity.getId()){
                user.setFirstName(entity.getFirstName());
                user.setLastName(entity.getLastName());
                user.setEmail(entity.getEmail());
            }
        }
    }

    @Override
    public void delete(User entity) {
        users.remove(entity);
    }
}
