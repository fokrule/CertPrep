package com.certprep.certprep.question.service;

import com.certprep.certprep.category.entity.Category;
import com.certprep.certprep.common.exception.ResourceNotFoundException;
import com.certprep.certprep.question.dto.QuestionDto;
import com.certprep.certprep.question.entity.Question;
import com.certprep.certprep.question.repository.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    private final QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public Question saveQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        System.out.println("getAllQuestions");
        return questionRepository.findAll();
    }

    public QuestionDto getQuestionById(long id) {
        QuestionDto singleQuestion =  questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question Could not found with id" + id));
        return singleQuestion;
    }
}
