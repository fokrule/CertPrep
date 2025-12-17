package com.certprep.certprep.question.controller;

import com.certprep.certprep.category.dto.CategoryDto;
import com.certprep.certprep.question.dto.QuestionDto;
import com.certprep.certprep.question.entity.Question;
import com.certprep.certprep.question.service.QuestionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/question")
public class QuestionController {
    private final QuestionService questionService;
    public QuestionController(QuestionService questionService){
        this.questionService = questionService;
    }

    @GetMapping
    public ResponseEntity<List<QuestionDto>> getAllQuestions(){
        List<Question> allQuestions = questionService.getAllQuestions();
        List<QuestionDto> dtos = allQuestions.stream()
                .map(q -> new QuestionDto(
                        q.getId(),
                        q.getQuestion(),
                        q.getExplanation(),
                        new CategoryDto(
                                q.getCategory().getId(),
                                q.getCategory().getName()
                        )
                ))
                .toList();
        return ResponseEntity.ok(dtos);
    }

    @PostMapping()
    public ResponseEntity<QuestionDto> createQuestion(@RequestBody Question question ) {
        Question saveQuestion = questionService.saveQuestion(question);
        QuestionDto questionDto = new QuestionDto(
                saveQuestion.getId(),
                saveQuestion.getQuestion(),
                saveQuestion.getExplanation(),
                new CategoryDto(
                        saveQuestion.getCategory().getId(),
                        saveQuestion.getCategory().getName()
                )
        );
        return new ResponseEntity<>(questionDto, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuestionDto> getQuestionById(@PathVariable long id){
        QuestionDto singleQuestion = questionService.getQuestionById(id);
    }
}
