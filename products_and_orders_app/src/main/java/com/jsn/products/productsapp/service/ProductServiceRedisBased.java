package com.jsn.products.productsapp.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.jsn.products.productsapp.model.Product;
import com.jsn.products.productsapp.repository.ProductRepository;

@Service
@EnableCaching	// knote: To enable caching for this class/layer
public class ProductServiceRedisBased {

	Logger logger = LogManager.getLogger(ProductServiceRedisBased.class);
	
    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAll() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Cacheable("product")	//knote: what is significance of this string?
    public Product getProductById(Long id) {
    	logger.info("[ProductServiceRedisBased] getProductById"+ id);
        return productRepository.findById(id).get();
    }

    @CacheEvict(value = "product", key = "#id")
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}