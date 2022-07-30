package all.repository;

import all.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(int id);

    List<Product> findByName(String name);


}
