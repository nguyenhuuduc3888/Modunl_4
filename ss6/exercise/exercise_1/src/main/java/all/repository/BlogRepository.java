package all.repository;

import all.model.Blog;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Blog> findAll() {
        TypedQuery<Blog> listPlayer = entityManager.createQuery("select b from Blog b", Blog.class);
        return listPlayer.getResultList();
    }

    @Override
    public void save(Blog blog) {
        entityManager.persist(blog);
    }

    @Override
    public void update(Blog blog) {
        entityManager.merge(blog);
    }

    @Override
    @Modifying
    public Blog findById(int id) {
        TypedQuery<Blog> query = entityManager.createQuery("select b from Blog as b where b.id = : id", Blog.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Blog blog = findById(id);
        entityManager.remove(blog);
    }

}
