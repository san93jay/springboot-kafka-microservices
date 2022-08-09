package com.kafka.micro.orderProducer;

import com.kafka.micro.base.service.dto.OrderEvent;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {


    @Autowired
    private NewTopic topic_name;
    @Autowired
    KafkaTemplate<String, OrderEvent> kafkaTemplate;


    public void sendOrder(OrderEvent orderEvent){
        Message<OrderEvent> message= MessageBuilder.withPayload(orderEvent)
                     .setHeader(KafkaHeaders.TOPIC,topic_name.name()).build();
        kafkaTemplate.send(message);
    }
}
