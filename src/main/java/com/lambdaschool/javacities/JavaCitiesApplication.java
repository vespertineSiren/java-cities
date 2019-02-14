package com.lambdaschool.javacities;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaCitiesApplication {

    public static final String EXCHANGE_NAME = "LambdaServer";
    public static final String QUEUE_NAME_CITIES1 = "Cities1PriorityQueue";
    public static final String QUEUE_NAME_CITIES2 = "Cities2PriorityQueue";
    public static final String QUEUE_NAME_SECRET = "SecretPriorityQueue";
    
    public static void main(String[] args) {
        SpringApplication.run(JavaCitiesApplication.class, args);
    }

}

