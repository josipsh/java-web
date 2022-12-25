package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.models.Category;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class CategoryRepositoryImpl implements IRepository<Category> {

    private final ArrayList<Category> categories;

    public CategoryRepositoryImpl() {
        categories = FakeDatabase.getCategories();
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
                item.setDisplayName(entity.getDisplayName());
                item.setLink(entity.getLink());
                item.setSubcategories(entity.getSubcategories());
            }
        }
    }

    @Override
    public void delete(Category entity) {
        categories.remove(entity);
    }
}
