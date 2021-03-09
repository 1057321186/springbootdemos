package com.project.mq.rabbitmqdemo;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RabbitmqdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqdemoApplication.class, args);
    }

    @Bean
    Jackson2JsonMessageConverter createMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
