package com.jsn.products.productsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.jsn.products.productsapp.model.Product;
import com.jsn.products.productsapp.service.ProductService;
import com.jsn.products.productsapp.service.ProductServiceRedisBased;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	Logger logger = LogManager.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductServiceRedisBased productServiceRedisBased;

    @PostMapping
    public Product postMethodName(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/redis/{id}")
    public Product getProductByIdWithRedisCache(@PathVariable Long id) {
        return productServiceRedisBased.getProductById(id);
    }

}
