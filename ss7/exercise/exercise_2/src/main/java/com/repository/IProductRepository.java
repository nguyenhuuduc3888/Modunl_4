package com.repository;

import com.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IProductRepository extends JpaRepository<Product, Integer> {
    @Modifying
    @Query(value = "select * from Product where product_name  like :name", nativeQuery = true)
    List<Product> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "update Product set product_name =:productName,product_price=:productPrice,producer=:producer where id=:id", nativeQuery = true)
    void update(@Param("productName") String productName, @Param("productPrice") String productPrice, @Param("producer") String producer, @Param("id") int id);
}
