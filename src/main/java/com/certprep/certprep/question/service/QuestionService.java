package com.certprep.certprep.question.service;

import com.certprep.certprep.question.entity.Question;
import com.certprep.certprep.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }
}
