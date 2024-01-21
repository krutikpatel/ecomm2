package com.jsn.products.productsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsn.products.productsapp.model.Product;
import com.jsn.products.productsapp.repository.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}