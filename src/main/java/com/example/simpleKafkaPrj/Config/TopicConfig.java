package com.example.simpleKafkaPrj.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class TopicConfig
{
    @Bean
    public NewTopic topic1()
    {
        return TopicBuilder.name("topic2").partitions(1).replicas(1)
                .build();
    }

    @Bean
    public NewTopic topic1_Output()
    {
        return TopicBuilder.name("topic2_Output").partitions(1).replicas(1)
                .build();
    }
}
