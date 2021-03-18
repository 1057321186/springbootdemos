package com.project.mq.rabbitmqdemo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
public class RabbitMQTest {

    // 注入template
    @Resource
    RabbitTemplate rabbitTemplate;

    // 生产者

    // hello world
    @Test
    void testHello() {
        // 投递
        rabbitTemplate.convertAndSend("hello1","你好1 MQ");
        rabbitTemplate.convertAndSend("hello2","你好2 MQ");
    }

    // 工作模型
    @Test
    void testWork() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("work","你好工作模型");
        }
    }


    // 广播模型
    @Test
    void testFanout() {
        rabbitTemplate.convertAndSend("logs","","广播发送的消息");
    }

    // 路由模型
    @Test
    void testRoute() {

    }
}

