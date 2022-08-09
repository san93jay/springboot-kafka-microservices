package com.kafka.micro.controller;

import com.kafka.micro.base.service.dto.Order;
import com.kafka.micro.base.service.dto.OrderEvent;
import com.kafka.micro.orderProducer.OrderProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/order")
public class OrderProducerController {

    @Autowired
    private OrderProducer orderProducer;

    @PostMapping("/order_kafka")
    public ResponseEntity<String> produceOrder(@RequestBody Order order){
        order.setOrderId(UUID.randomUUID().toString());
        OrderEvent orderEvent=new OrderEvent();
        orderEvent.setOrder(order);
        orderEvent.setMessage("Order is in Pending state");
        orderEvent.setStatus("Pending");
        orderProducer.sendOrder(orderEvent);
        return  new ResponseEntity<>("Oder sent to order consumer successfully !",HttpStatus.OK);
    }
}
