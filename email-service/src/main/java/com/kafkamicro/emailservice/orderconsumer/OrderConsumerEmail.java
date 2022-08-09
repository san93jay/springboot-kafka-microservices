package com.kafkamicro.emailservice.orderconsumer;

import com.kafka.micro.base.service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumerEmail {

    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrder(OrderEvent orderEvent){
        System.out.println(orderEvent.toString());
    }
}
