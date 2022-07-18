package all.service;

import all.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> finAll();

    Product findById(int id);

    List<Product> findByName(String name);

    void save(Product product);

    void update(int id, Product product);

    void delete(Product  product);

}
