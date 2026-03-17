package com.certprep.certprep.notification.event;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamSubmittedEvent {

    private Long submissionId;
    private Long userId;
    private Long examId;
    private Integer score;

}