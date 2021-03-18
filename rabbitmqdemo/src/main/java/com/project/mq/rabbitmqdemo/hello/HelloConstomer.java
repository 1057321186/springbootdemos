package com.project.mq.rabbitmqdemo.hello;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queuesToDeclare = @Queue("hello1")) // 指定队列
public class HelloConstomer {

    // 接收消息方式一
    @RabbitHandler
    public void received(String message) {
        System.out.println("接收到消息 " + message);
    }

    // 接收消息方式二
    @RabbitListener(queuesToDeclare = @Queue("hello2"))
    public void received2(String message) {
        System.out.println("接收到消息 " + message);
    }
}
