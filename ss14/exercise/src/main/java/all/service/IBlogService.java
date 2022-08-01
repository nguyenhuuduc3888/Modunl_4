package all.service;

import all.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findByName(String name, Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    void update(Blog blog);

    void delete(int id);

}
