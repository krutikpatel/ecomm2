package com.jsn.orderprocessor.kafka;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsn.orderprocessor.model.Order;
import com.jsn.orderprocessor.orderprocessor.OrderProcessorWorker;

@Component
public class OrderMessageConsumer {
	Logger logger = LogManager.getLogger(OrderMessageConsumer.class);
	
	ObjectMapper mapper = new ObjectMapper();
	//@Value(value = "${app.orderprocessor.topic.orders}")
    //private String orderTopic = "orders";
	
	@Autowired
	OrderProcessorWorker orderProcessor;
	
	//@KafkaListener(topics = "orders", groupId = "processordergroup")
	//@KafkaListener(topics = "orders", groupId = "gp1")
	public void listenOrdersTopic(String message) {
	    logger.info("Received Message in group foo: " + message);
	    //make json to pojo
	    
		try {
			Order order;
			order = mapper.readValue(message, Order.class);
		//	orderProcessor.processOrder(order);
		} catch (JsonMappingException e) {
			logger.error("[listenOrdersTopic] exception in parsing order"+e);
		} catch (JsonProcessingException e) {
			logger.error("[listenOrdersTopic] exception in parsing order"+e);
		}
	    
	}
}
