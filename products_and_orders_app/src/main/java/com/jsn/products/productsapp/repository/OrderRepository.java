package com.jsn.products.productsapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsn.products.productsapp.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
