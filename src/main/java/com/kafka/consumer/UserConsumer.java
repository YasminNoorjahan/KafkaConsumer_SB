package com.kafka.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class UserConsumer {

    @Autowired
    private ObjectMapper objectMapper;

    @KafkaListener(topics = "user", groupId = "test")
    public void receiveUser(String message) throws JsonProcessingException {
        User User = objectMapper.readValue(message, User.class);
        System.out.println("Received User: " + User);
        // Implement your business logic here to process the User data
    }
}
