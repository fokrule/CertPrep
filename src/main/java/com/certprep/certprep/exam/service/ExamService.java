package com.certprep.certprep.exam.service;

import com.certprep.certprep.exam.entity.Exam;
import com.certprep.certprep.exam.repository.ExamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamService {

    private final ExamRepository examRepository;

    public Exam createExam(Exam exam){
        return examRepository.save(exam);
    }

    public List<Exam> getAllExams(){
        return examRepository.findAll();
    }
}