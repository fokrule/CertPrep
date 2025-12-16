package com.certprep.certprep.question.controller;

import com.certprep.certprep.question.entity.Question;
import com.certprep.certprep.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @PostMapping()
    public ResponseEntity<Question> createQuestion(@RequestBody Question question ) {
        Question saveQuestion = questionService.saveQuestion(question);
        return new ResponseEntity<>(saveQuestion, HttpStatus.CREATED);
    }
}
