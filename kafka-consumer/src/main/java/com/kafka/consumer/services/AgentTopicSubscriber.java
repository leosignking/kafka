package com.kafka.consumer.services;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AgentTopicSubscriber {

    private static final Logger LOGGER = LoggerFactory.getLogger((AgentTopicSubscriber.class));

    //@SendTo("user")
    @KafkaListener(topics = "agent")
    public String agentTopicConsume(Object message) {
        LOGGER.info((String.format("#### -> Agent Topic Consumed message -> %s", message)));

        //Serialize the object
        JSONObject jsonObject = new JSONObject(message);
        return jsonObject.get("data").toString();
    }

}
