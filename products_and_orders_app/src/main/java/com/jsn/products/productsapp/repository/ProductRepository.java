package com.jsn.products.productsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsn.products.productsapp.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
