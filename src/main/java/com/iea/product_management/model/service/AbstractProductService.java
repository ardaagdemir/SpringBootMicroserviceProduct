package com.iea.product_management.model.service;

import com.iea.product_management.model.entity.Product;
import com.iea.product_management.model.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public abstract class AbstractProductService implements EntityService<Product, Integer>
{
    @Autowired
    protected ProductRepository productRepository;

    protected abstract List<Product> findByPriceGreaterThan(Double price);

    protected abstract List<Product> findByPriceGreaterThanEqual(Double price);
}
