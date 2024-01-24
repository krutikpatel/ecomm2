package com.jsn.products.productsapp.kafka;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfig {
    
    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    public static final String TOPIC_ORDER = "orders";

    @Bean
    public KafkaAdmin kafkaAdmin() {
        Map<String, Object> configs = new HashMap<>();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapAddress);
        return new KafkaAdmin(configs);
    }
    
    /*
     * knote: creating a topic called "order". may be this method gets called automatically - verified - it was created
     * 	partition = 1, replica = 1
     */
    @Bean
    public NewTopic createOrderTopic() {
    	return TopicBuilder.name(TOPIC_ORDER)
		      .partitions(1)
		      .replicas(1)
		      //.config(TopicConfig.COMPRESSION_TYPE_CONFIG, "zstd") //knote: for message compression
		      .build();
    }
}