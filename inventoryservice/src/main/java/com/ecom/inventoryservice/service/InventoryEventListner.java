package com.ecom.inventoryservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryEventListner {

    @Autowired
    private KafkaTemplate<String, OrderEvent> kafkaTemplate;



    pu



}
