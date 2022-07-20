package all.service;

import all.model.Product;

import java.util.List;

public interface IProductService {

    Product findById(int id);

    List<Product> findAll();

    List<Product> findByName(String name);

    void delete(int id);
}
