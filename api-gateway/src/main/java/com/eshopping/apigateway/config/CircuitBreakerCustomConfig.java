package com.eshopping.apigateway.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Slf4j
@Configuration
public class CircuitBreakerCustomConfig {

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;


    @PostConstruct
    public void registerEvent(){
        var eventPus = circuitBreakerRegistry.circuitBreaker("orderCircuitBreaker").getEventPublisher();
        eventPus.onEvent(event -> log.info("Event trigger name : {} event type : {}", event.getCircuitBreakerName(), event.getEventType()));
        eventPus.onStateTransition(event -> log.info("State transition To state : {} from state {}", event.getStateTransition().getToState(), event.getStateTransition().getFromState()));
    }
}
