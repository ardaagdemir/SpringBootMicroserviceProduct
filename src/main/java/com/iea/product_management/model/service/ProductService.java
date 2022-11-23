package com.iea.product_management.model.service;


import com.iea.product_management.model.entity.Product;
import com.iea.product_management.utility.ExceptionMessageType;
import com.iea.product_management.utility.Util;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService extends AbstractProductService
{
    @Override
    protected List<Product> findByPriceGreaterThan(Double price)
    {
        return productRepository.findByPriceGreaterThan(price);
    }

    @Override
    protected List<Product> findByPriceGreaterThanEqual(Double price)
    {
        return productRepository.findByPriceGreaterThanEqual(price);
    }

    @Override
    public Product findByID(Integer id)
    {
        return productRepository.findById(id)
                .orElseThrow( () -> new RuntimeException(ExceptionMessageType.FIND_BY_ID.getValue() ) );
    }

    @Override
    public List<Product> getAll()
    {
        return productRepository.findAll();
    }

    @Override
    public Product save(Product entity)
    {
        try
        {
            if(entity != null)
            {
                return productRepository.save(entity);
            }
            return  new Product();
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionMessage(e);
            return  new Product();
        }
        catch (OptimisticLockingFailureException e)
        {
            Util.showGeneralExceptionMessage(e);
            return  new Product();
        }
    }

    @Override
    public void deleteByID(Integer id)
    {
        try
        {
            if(id != null)
            {
                productRepository.deleteById(id);
            }
        }
        catch (IllegalArgumentException e)
        {
            Util.showGeneralExceptionMessage(e);
        }
    }
}
