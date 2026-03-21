package com.certprep.certprep.exam.service;

import com.certprep.certprep.exam.dto.ExamRequest;
import com.certprep.certprep.exam.dto.ExamResponse;
import com.certprep.certprep.exam.entity.Exam;
import com.certprep.certprep.exam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import com.certprep.certprep.common.exception.BadRequestException;
import com.certprep.certprep.common.exception.ResourceNotFoundException;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public ExamResponse createExam(ExamRequest request) {
        Exam exam = new Exam();
        exam.setTitle(request.getTitle());
        exam.setDescription(request.getDescription());

        Exam saved = examRepository.save(exam);

        return mapToResponse(saved);
    }

    public List<ExamResponse> getAllExams() {
        return examRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    public ExamResponse getExamById(Long id) {
        Exam exam = examRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exam not found"));

        return mapToResponse(exam);
    }

    private ExamResponse mapToResponse(Exam exam) {
        ExamResponse res = new ExamResponse();
        res.setId(exam.getId());
        res.setTitle(exam.getTitle());
        res.setDescription(exam.getDescription());
        return res;
    }
}