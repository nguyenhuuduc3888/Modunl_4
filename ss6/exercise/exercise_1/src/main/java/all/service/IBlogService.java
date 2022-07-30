package all.service;

import all.model.Blog;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    void update(Blog blog);

    void delete(int id);

    Blog findById(int id);

    void save(Blog blog);


}
