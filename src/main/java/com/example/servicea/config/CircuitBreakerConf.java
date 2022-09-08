//package com.example.servicea.config;
//
//import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
//import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.io.IOException;
//import java.time.Duration;
//import java.util.concurrent.TimeoutException;
//
//@Configuration
//public class CircuitBreakerConf {
////    CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.ofDefaults();
//CircuitBreakerConfig circuitBreakerConfig =     CircuitBreakerConfig.custom()
//        .failureRateThreshold(50)
//        .waitDurationInOpenState(Duration.ofMillis(1000))
//        .permittedNumberOfCallsInHalfOpenState(2)
//        .slidingWindowSize(2)
//        .recordExceptions(IOException.class, TimeoutException.class)
//        .automaticTransitionFromOpenToHalfOpenEnabled(true)
//        .build();
//
////
////    CircuitBreakerRegistry circuitBreakerRegistry =
////            CircuitBreakerRegistry.of(circuitBreakerConfig);
//
//}
