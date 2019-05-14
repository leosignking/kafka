package com.kafka.consumer.engine;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger((Consumer.class));

    @KafkaListener(topics = "agent")
    public void consume(Object message) {
        if(message instanceof JSONObject) {
            LOGGER.info("json object");
        }
        LOGGER.info((String.format("#### -> Consumed message -> %s", message)));
    }
}
