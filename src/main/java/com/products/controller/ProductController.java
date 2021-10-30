package com.products.controller;

import com.products.dto.PromoCode;
import com.products.entity.Product;
import com.products.entity.ProductRepo;
import com.products.feignclient.PromoCodeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    PromoCodeClient promoCodeClient;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        PromoCode promoCode = promoCodeClient.fetchPromoCode(product.getPromoCode());
        product.setPrice(product.getPrice().subtract(promoCode.getDiscount()));
        return productRepo.save(product);
    }



}
