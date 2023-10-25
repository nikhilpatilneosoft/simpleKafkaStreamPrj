package com.example.simpleKafkaPrj.services;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class consumer {

    @KafkaListener(topics = "topic2_Output", groupId = "1")
    public void consumeLong(Long l)
    {
        System.out.println(l);
    }
}
