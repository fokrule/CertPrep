package com.certprep.certprep.question.service;

import com.certprep.certprep.submission.exception.ResourceNotFoundException;
import com.certprep.certprep.question.dto.QuestionDto;
import com.certprep.certprep.question.entity.QuestionBK;
import com.certprep.certprep.question.repository.QuestionBckRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionBckService {
    private final QuestionBckRepository questionRepository;
    public QuestionBckService(QuestionBckRepository questionRepository){
        this.questionRepository = questionRepository;
    }
    public QuestionBK saveQuestion(QuestionBK question) {
        return questionRepository.save(question);
    }

    public List<QuestionBK> getAllQuestions() {
        System.out.println("getAllQuestions");
        return questionRepository.findAll();
    }

    public QuestionDto getQuestionById(long id) {

        QuestionBK singleQuestion = questionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Question Could not found with id" + id));

        QuestionDto questionDto = new QuestionDto();
        questionDto.setId(singleQuestion.getId());
//        questionDto.setQuestion(singleQuestion.getQuestion());
//        questionDto.setExplanation(singleQuestion.getExplanation());

        return questionDto;
    }
}
