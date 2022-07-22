package com.repository;

import com.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IProductRepository extends JpaRepository<Product, Integer> {



    @Transactional
    @Modifying
    @Query(value = "update Product set product_name =:productName,product_price=:productPrice,producer=:producer where id=:id", nativeQuery = true)
    void update(@Param("productName") String productName, @Param("productPrice") String productPrice, @Param("producer") String producer, @Param("id") int id);

    @Query(value = " select * from product where product_name like :name ", nativeQuery = true)
    Page<Product> findAll(Pageable pageable,@Param("name") String name);
}
