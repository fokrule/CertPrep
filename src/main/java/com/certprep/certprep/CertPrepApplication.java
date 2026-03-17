package com.certprep.certprep;

import com.certprep.certprep.kafka.TestProducer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CertPrepApplication {

    public static void main(String[] args) {
        SpringApplication.run(CertPrepApplication.class, args);
    }

    @Bean
    CommandLineRunner run(TestProducer producer) {
        return args -> {
            producer.send("test-message");
        };
    }

}
