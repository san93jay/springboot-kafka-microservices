package com.kafkamicro.orderConsumer;

import com.kafka.micro.base.service.dto.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
public class OrderConsumerStock {


    @KafkaListener(topics = "${spring.kafka.topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeOrder(OrderEvent orderEvent){
        System.out.println(orderEvent.toString());
    }
}
