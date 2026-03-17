package com.certprep.certprep.submission.service;


import com.certprep.certprep.submission.entity.Submission;
import com.certprep.certprep.submission.repository.SubmissionRepository;
import com.certprep.certprep.notification.producer.NotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubmissionService {

    private final SubmissionRepository submissionRepository;
    private final NotificationProducer notificationProducer;

    public Submission submitExam(Long userId, Long examId){

        Submission submission = Submission.builder()
                .userId(userId)
                .examId(examId)
                .score(80)
                .build();

        Submission saved = submissionRepository.save(submission);

        notificationProducer.examSubmittedEvent(saved);

        return saved;
    }
}