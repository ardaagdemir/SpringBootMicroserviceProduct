package com.iea.product_management.controller;

import com.iea.product_management.model.entity.Product;
import com.iea.product_management.model.service.AbstractProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequestMapping("api/product")
@RestController
public class ProductController
{
    @Autowired
    private AbstractProductService productService;

    // api/product/{productID}
    @DeleteMapping("{productID}")
    public ResponseEntity delete(@PathVariable Integer productID)
    {
        productService.deleteByID(productID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAll()
    {
        List<Product> productList = productService.getAll();

        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product)
    {
        product.setCreated(new Date());
        Product savedProduct = productService.save(product);

        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }
}
