package com.service;


import com.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(Integer id);

    List<Product> findByName(String name);

}
