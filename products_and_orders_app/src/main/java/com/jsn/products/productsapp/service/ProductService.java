package com.jsn.products.productsapp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsn.products.productsapp.model.Product;
import com.jsn.products.productsapp.repository.ProductRepository;

@Service
public class ProductService {
	Logger logger = LogManager.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
    	logger.info("[ProductService] NO REDIS getProductById"+id);
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}