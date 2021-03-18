package com.project.mq.rabbitmqdemo.fanout;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FanOutConstomer {

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                        exchange = @Exchange(value = "logs",type = "fanout")// 绑定的交换机
            )
    })
    public void received1(String message) {
        System.out.println("message1 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")// 绑定的交换机
            )
    })
    public void received2(String message) {
        System.out.println("message2 = " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue,//创建临时队列
                    exchange = @Exchange(value = "logs",type = "fanout")// 绑定的交换机
            )
    })
    public void received3(String message) {
        System.out.println("message3 = " + message);
    }
}
