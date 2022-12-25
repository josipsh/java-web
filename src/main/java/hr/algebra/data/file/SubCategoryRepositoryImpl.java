package hr.algebra.data.file;

import hr.algebra.data.IRepository;
import hr.algebra.models.SubCategory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

class SubCategoryRepositoryImpl implements IRepository<SubCategory> {

    private final ArrayList<SubCategory> subCategories;

    public SubCategoryRepositoryImpl() {
        subCategories = FakeDatabase.getSubcategories();
    }

    @Override
    public Collection<SubCategory> getAll() {
        return new ArrayList<>(subCategories);
    }

    @Override
    public SubCategory getById(int id) {
        Optional<SubCategory> subCategory = subCategories.stream().filter(x -> x.getId() == id).findFirst();
        return subCategory.orElseGet(() -> subCategories.get(0));
    }

    @Override
    public void add(SubCategory entity) {
        subCategories.add(entity);
    }

    @Override
    public void edit(SubCategory entity) {
        for (SubCategory item : subCategories) {
            if (item.getId() == entity.getId()){
                item.setDisplayName(entity.getDisplayName());
                item.setLink(entity.getLink());
                item.setCategory(entity.getCategory());
            }
        }
    }

    @Override
    public void delete(SubCategory entity) {
        subCategories.remove(entity);
    }
}
