package com.products.controller;

import com.products.entity.Product;
import com.products.entity.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productRepo.save(product);
    }


}
