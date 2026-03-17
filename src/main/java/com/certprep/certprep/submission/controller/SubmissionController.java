package com.certprep.certprep.submission.controller;


import com.certprep.certprep.submission.entity.Submission;
import com.certprep.certprep.submission.service.SubmissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/submissions")
@RequiredArgsConstructor
public class SubmissionController {

    private final SubmissionService submissionService;

    @PostMapping("/submit")
    public ResponseEntity<Submission> submit(
            @RequestParam Long userId,
            @RequestParam Long examId){

        return ResponseEntity.ok(
                submissionService.submitExam(userId, examId)
        );
    }
}
