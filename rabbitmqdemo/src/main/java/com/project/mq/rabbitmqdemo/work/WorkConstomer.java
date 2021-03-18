package com.project.mq.rabbitmqdemo.work;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class WorkConstomer {

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void received1(String message) {
        System.out.println("消费者1:"+message);
    }

    @RabbitListener(queuesToDeclare = @Queue("work"))
    public void received2(String message) {
        System.out.println("消费者2:"+message);
    }

}
