package all.service;

import all.model.Blog;
import all.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {

    List<Category> findAll();

    Category findById(int id);

    Page<Category> findByName(String name, Pageable pageable);

    void save(Category category);

    void update(Category category);

    void delete(int id);
}
