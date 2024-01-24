package com.jsn.products.productsapp.service;

import java.util.List;

import org.apache.kafka.common.serialization.StringSerializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsn.products.productsapp.kafka.MessagePublisher;
import com.jsn.products.productsapp.model.Order;
import com.jsn.products.productsapp.repository.OrderRepository;

@Service
public class OrderService {
	Logger logger = LogManager.getLogger(OrderService.class);
	
    @Autowired
    private OrderRepository orderRepository;

    //MessagePublisher kafkaMessagePublisher = new MessagePublisher();
    @Autowired
    MessagePublisher kafkaMessagePublisher;
    
    public List<Order> listAll() {
        return orderRepository.findAll();
    }

    public Order createOrder(Order order) {
    	Order createdOrder = orderRepository.save(order);
    	kafkaMessagePublisher.sendOrderMessage(createdOrder);
        return createdOrder;
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }
}