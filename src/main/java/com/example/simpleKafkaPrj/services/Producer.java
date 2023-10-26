package com.example.simpleKafkaPrj.services;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Producer {

    @Autowired
    private KafkaTemplate<String, Integer> kafkaTemplate;

    public void sendString(List<Integer> stringList)
    {
        for(Integer s : stringList)
        {
            ProducerRecord<String, Integer> record = new ProducerRecord<>("topic2", "myKey1 ", s);
            kafkaTemplate.send(record);
        }
    }
}
