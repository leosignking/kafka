package com.kafka.consumer.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserTopicSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserTopicSubscriber.class);

    @KafkaListener(topics = "user")
    public void userTopicConsume(String message) {
        LOGGER.info((String.format("#### -> User Topic Consumed message -> %s", message)));
    }
}
