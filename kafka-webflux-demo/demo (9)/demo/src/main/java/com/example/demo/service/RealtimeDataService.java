package com.example.demo.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class RealtimeDataService {

    @KafkaListener(topics = "${kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        // Push messages to the frontend in real-time (to be implemented)
        System.out.println("Received message: " + message);
    }
}
