package all.repository;

import all.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    Product findById(int id);


}
