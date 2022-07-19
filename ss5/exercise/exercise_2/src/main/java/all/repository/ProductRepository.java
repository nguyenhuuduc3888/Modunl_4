package all.repository;

import all.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
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
        return entityManager.find(Product.class, id);
    }

    @Override
    public void delete(Product product) {
        entityManager.remove(product);
    }

}
