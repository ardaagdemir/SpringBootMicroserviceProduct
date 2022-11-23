package com.iea.product_management.model.repository;

import com.iea.product_management.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer>
{
    // SELECT * FROM PRODUCTS WHERE PRICE > ?;
    List<Product> findByPriceGreaterThan(Double price);


    // SELECT * FROM PRODUCTS WHERE PRICE >= ?;
    List<Product> findByPriceGreaterThanEqual(Double price);
}
