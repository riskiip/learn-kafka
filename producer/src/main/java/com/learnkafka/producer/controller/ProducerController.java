package com.learnkafka.producer.controller;

import com.learnkafka.producer.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("kafka")
public class ProducerController {
    private static final String TOPIC = "KafkaExample";

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @GetMapping("/publish/{name}")
    public String post(@PathVariable("name") final String name) {
        kafkaTemplate.send(TOPIC, new User(name, "IT", 1000L));
        return "Publish successfully";
    }
}
