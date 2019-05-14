package com.kafka.producer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public  void sendMessage(String topic, Object message) {
        LOGGER.info(String.format("#### -> Producer message -> %s", message));
        this.kafkaTemplate.send(topic, message);
    }
}
