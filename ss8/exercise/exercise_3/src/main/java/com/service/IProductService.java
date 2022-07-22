package com.service;


import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IProductService {
    Page<Product> findAll(Pageable pageable, String s);

    void save(Product product);

    void update(Product product);

    void delete(int id);

    Product findById(Integer id);



}
