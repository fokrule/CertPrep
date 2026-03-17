package com.certprep.certprep.notification.producer;


import com.certprep.certprep.notification.event.ExamSubmittedEvent;
import com.certprep.certprep.submission.entity.Submission;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationProducer {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    private static final String TOPIC = "exam-submitted";

    public void examSubmittedEvent(Submission submission){

        ExamSubmittedEvent event =
                new ExamSubmittedEvent(
                        submission.getId(),
                        submission.getUserId(),
                        submission.getExamId(),
                        submission.getScore()
                );

        kafkaTemplate.send(TOPIC, event);
    }
}
