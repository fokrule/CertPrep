package com.certprep.certprep.notification.consumer;


import com.certprep.certprep.notification.event.ExamSubmittedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @KafkaListener(topics = "exam-submitted", groupId = "notification-group")
    public void consume(ExamSubmittedEvent event){

        System.out.println("Exam submitted event received");
        System.out.println("User: " + event.getUserId());
        System.out.println("Score: " + event.getScore());

    }
}
