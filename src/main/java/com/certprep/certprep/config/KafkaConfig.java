package com.certprep.certprep.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic examSubmittedTopic(){
        return new NewTopic("exam-submitted", 3, (short)1);
    }

}