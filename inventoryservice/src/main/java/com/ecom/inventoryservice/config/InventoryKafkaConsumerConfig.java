package com.ecom.inventoryservice.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;


@Configuration
public class InventoryKafkaConsumerConfig {


    @Bean
    public NewTopic orderTopic(){
        return TopicBuilder
                .name("order-created")
                .compact()
                .build();
    }

    @Bean
    public NewTopic InventoryTopic(){
        return TopicBuilder
                .name("inventory-exists")
                .compact()
                .build();
    }
}
