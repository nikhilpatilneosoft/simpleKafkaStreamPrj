package com.example.simpleKafkaPrj.streams;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KafkaStreams;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.Topology;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Produced;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Properties;

@Service
public class CountStream {

    private Properties props = new Properties();

    @Autowired
    private NewTopic topic1;
    
    public void countStreamProp()
    {
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "my-kafka-streams-app");
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, "org.apache.kafka.common.serialization.Serdes.String");
//        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, "org.apache.kafka.common.serialization.Serdes.String");
        //props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

        StreamsBuilder builder = new StreamsBuilder();
        KStream<String, Integer> firstStream = builder.stream("topic2", Consumed.with(Serdes.String(), Serdes.Integer()));

        firstStream.peek((key, value) -> System.out.println("Key: " + key+ " Value: "+ value))
                .groupByKey()
                .count()
                .toStream()
                .to("topic2_Output", Produced.with(Serdes.String(), Serdes.Long()));

        Topology topology = builder.build();

        KafkaStreams streams = new KafkaStreams(topology, props);
        streams.start();

        Runtime.getRuntime().addShutdownHook(new Thread(streams::close));
    }
}