package com.jsn.orderprocessor.orderprocessor;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jsn.orderprocessor.model.Order;

@SpringBootApplication
//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})	//knote: we dont want DB in this app
public class OrderprocessorApplication {

	static Logger logger = LogManager.getLogger(OrderprocessorApplication.class);
	ObjectMapper mapper = new ObjectMapper();
	//@Autowired
	//OrderMessageConsumer orderConsumer;
	
	OrderProcessorWorker orderProcessor = new OrderProcessorWorker();
	
	public static void main(String[] args) {
		SpringApplication.run(OrderprocessorApplication.class, args);
		logger.info("[OrderprocessorApplication] kafka consumer app started");
		
	}
	
	@KafkaListener(topics = "orders", groupId = "gp1")
    public void listener1(String message) {
		logger.info("Received Message in group foo: " + message);
	    //make json to pojo
	    
		try {
			Order order;
			order = mapper.readValue(message, Order.class);
			orderProcessor.processOrder(order);
		} catch (JsonMappingException e) {
			logger.error("[listenOrdersTopic] exception in parsing order"+e);
		} catch (JsonProcessingException e) {
			logger.error("[listenOrdersTopic] exception in parsing order"+e);
		}
    }
    
}
