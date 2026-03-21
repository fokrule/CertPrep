package com.certprep.certprep.exam.service;
import com.certprep.certprep.common.exception.BadRequestException;
import com.certprep.certprep.common.exception.ResourceNotFoundException;
import com.certprep.certprep.exam.dto.OptionRequest;
import com.certprep.certprep.exam.dto.OptionResponse;
import com.certprep.certprep.exam.dto.QuestionRequest;
import com.certprep.certprep.exam.dto.QuestionResponse;
import com.certprep.certprep.exam.entity.Exam;
import com.certprep.certprep.exam.entity.Option;
import com.certprep.certprep.exam.entity.Question;
import com.certprep.certprep.exam.entity.QuestionType;
import com.certprep.certprep.exam.repository.ExamRepository;
import com.certprep.certprep.exam.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final ExamRepository examRepository;

    public QuestionResponse createQuestion(QuestionRequest request) {

        Exam exam = examRepository.findById(request.getExamId())
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));

        validateOptions(request);

        Question question = new Question();
        question.setQuestionText(request.getQuestionText());
        question.setType(request.getType());
        question.setExam(exam);

        List<Option> options = request.getOptions().stream()
                .map(optReq -> {
                    Option opt = new Option();
                    opt.setText(optReq.getText());
                    opt.setCorrect(optReq.isCorrect());
                    opt.setQuestion(question);
                    return opt;
                }).toList();

        question.setOptions(options);

        Question saved = questionRepository.save(question);

        return mapToResponse(saved);
    }

    public List<QuestionResponse> getQuestionsByExam(Long examId) {
        return questionRepository.findByExamId(examId)
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    // 🔥 Core validation logic
    private void validateOptions(QuestionRequest request) {

        long correctCount = request.getOptions().stream()
                .filter(OptionRequest::isCorrect)
                .count();

        if (request.getType() == QuestionType.SINGLE_CHOICE && correctCount != 1) {
            throw new BadRequestException("Single choice must have exactly one correct answer");
        }

        if (request.getType() == QuestionType.MULTIPLE_CHOICE && correctCount < 1) {
            throw new BadRequestException("Multiple choice must have at least one correct answer");
        }
    }

    private QuestionResponse mapToResponse(Question q) {

        QuestionResponse res = new QuestionResponse();
        res.setId(q.getId());
        res.setQuestionText(q.getQuestionText());
        res.setType(q.getType());

        List<OptionResponse> options = q.getOptions().stream()
                .map(opt -> {
                    OptionResponse o = new OptionResponse();
                    o.setId(opt.getId());
                    o.setText(opt.getText());
                    return o;
                }).toList();

        res.setOptions(options);

        return res;
    }
}
