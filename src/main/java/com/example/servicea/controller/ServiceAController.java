package com.example.servicea.controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/a")
public class ServiceAController {

    public static final Logger logger = LoggerFactory.getLogger(ServiceAController.class);

    RestTemplate restTemplate = new RestTemplate();
    private static final String BASE_URL = "http://localhost:8082/";
    private static final String SERVICE_A = "serviceA";

    public int count = 1;
    @GetMapping()
//    @CircuitBreaker(name = SERVICE_A,fallbackMethod = "serviceAFallBack" )
    @Retry(name = SERVICE_A)
    public String serviceA(){
        var url = BASE_URL+"b";
//        logger.info("data: {}",restTemplate.getForEntity(url,String.class));
        logger.info("Retry method called: " + count++ + " times");

        return restTemplate.getForObject(url,String.class);
    }
//    public String serviceAFallBack(Exception e){
//        var res =  "This is a service A fallback";
//        logger.info("data:{}", res);
//        return res;
//    }
}
