package all.service.ipml;

import all.model.Blog;
import all.repository.IBlogRepository;
import all.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository blogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAllBlog(pageable);
    }

    @Override
    public List<Blog> listCategory(int categoryId) {
        return blogRepository.listCategory(categoryId);
    }

    @Override
    public Page<Blog> findByName(String name, Pageable pageable) {
        return blogRepository.findByName(name, pageable);
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void update(Blog blog) {
        blogRepository.update(blog.getBlogName(), blog.getBlogDetail(), blog.getDayCreate(), blog.getCategory().getCategoryId(), blog.getId());
    }

    @Override
    public void delete(int id) {
        blogRepository.delete(id);
    }

    @Override
    public List<Blog> findAll() {
        return this.blogRepository.findAll();
    }
}
