package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.models.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class CategoryRepositoryImpl implements IRepository<Category> {

    private final ArrayList<Category> categories;

    public CategoryRepositoryImpl() {
        categories = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Category cat = new Category(i, "Category " + i);
            categories.add(cat);
        }
    }

    @Override
    public Collection<Category> getAll() {
        return new ArrayList<>(categories);
    }

    @Override
    public Category getById(int id) {
        Optional<Category> category = categories.stream().filter(x -> x.getId() == id).findFirst();
        return category.orElseGet(() -> categories.get(0));
    }

    @Override
    public void add(Category entity) {
        categories.add(entity);
    }

    @Override
    public void edit(Category entity) {
        for (Category item : categories) {
            if (item.getId() == entity.getId()) {
                item.setName(entity.getName());
            }
        }
    }

    @Override
    public void delete(Category entity) {
        categories.remove(entity);
    }
}
