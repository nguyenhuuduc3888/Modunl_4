package all.repository;

import all.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.lang.reflect.Type;
import java.util.List;

@Repository
@Transactional
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        TypedQuery<Product> listPlayer = entityManager.createQuery("select s from Product s", Product.class);
        return listPlayer.getResultList();
    }

    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    @Modifying
    public Product findById(int id) {
       TypedQuery<Product> query = entityManager.createQuery("select s from Product as s where s.id = : id", Product.class).setParameter("id", id);
       return query.getSingleResult();
    }

    @Override
    public void delete(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

}
