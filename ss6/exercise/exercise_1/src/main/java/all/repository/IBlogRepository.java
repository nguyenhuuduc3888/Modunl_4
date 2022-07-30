package all.repository;


import all.model.Blog;

import java.util.List;

public interface IBlogRepository {
    List<Blog> findAll();

    void save(Blog blog);

    void update(Blog blog);

    Blog findById(int id);

    void delete(int id);

}
