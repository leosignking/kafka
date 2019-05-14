package com.kafka.producer.controllers;

import com.kafka.producer.services.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam(value = "topic", required = true) String topic,
                                        @RequestBody Object message) {
        this.producer.sendMessage(topic, message);
    }
}
