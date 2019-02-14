package com.lambdaschool.javacities;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JavaCitiesApplication {

    public static final String EXCHANGE_NAME = "LambdaServer";
    public static final String QUEUE_NAME_CITY1 = "Cities1PriorityQueue";
    public static final String QUEUE_NAME_CITY2 = "Cities2PriorityQueue";
    public static final String QUEUE_NAME_SECRET = "SecretPriorityQueue";

    public static void main(String[] args) {
        SpringApplication.run(JavaCitiesApplication.class, args);
    }

    @Bean
    public TopicExchange appExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    public Queue appQueueSecret()
    {
        return new Queue(QUEUE_NAME_SECRET);
    }

    @Bean
    public Binding declareBindingSecret()
    {
        return BindingBuilder.bind(appQueueSecret()).to(appExchange()).with(QUEUE_NAME_SECRET);
    }

    public Queue appQueueCities1()
    {
        return new Queue(QUEUE_NAME_CITY1);
    }

    @Bean
    public Binding declareBindingLow()
    {
        return BindingBuilder.bind(appQueueCities1()).to(appExchange()).with(QUEUE_NAME_CITY1);
    }

    @Bean
    public Queue appQueueCities2()
    {
        return new Queue(QUEUE_NAME_CITY2);
    }

    @Bean
    public Binding declareBindingHigh()
    {
        return BindingBuilder.bind(appQueueCities2()).to(appExchange()).with(QUEUE_NAME_CITY2);
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}

