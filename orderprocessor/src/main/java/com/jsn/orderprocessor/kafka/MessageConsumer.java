package com.jsn.orderprocessor.kafka;

import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {
	private static final String SIMPLE_CONTAINER_FACTORY = "simpleKafkaListenerContainerFactory";	//knote: still does not work. V imp - same as the name of Bean in KakfaConsumerConfig
	
	@KafkaListener(topics = "orders", groupId = "my-group-id", containerFactory = SIMPLE_CONTAINER_FACTORY)	//knote: still does not work. if containerFactory is not set, listener does not work. we need to provide bean name of containerFactory
    public void listen(String message) {
        System.out.println("Received message: " + message);
    }
}
