package all.service;

import all.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> listCategory(int categoryId);

    Page<Blog> findByName(String name, Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void update(Blog blog);

    void delete(int id);

    List<Blog> findAll();
}
