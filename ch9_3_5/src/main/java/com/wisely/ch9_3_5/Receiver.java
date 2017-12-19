package com.wisely.ch9_3_5;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @RabbitListener(queues = "my-queue") // 指定要监听的队列
    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
