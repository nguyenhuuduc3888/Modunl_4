package all.service.ipml;

import all.model.Category;
import all.repository.ICategoryRepository;
import all.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Page<Category> findByName(String name, Pageable pageable) {
        return categoryRepository.findByName(name, pageable);
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        categoryRepository.update(category.getCategoryName(), category.getCategoryId());
    }

    @Override
    public void delete(int id) {
        categoryRepository.delete(id);
    }
}
