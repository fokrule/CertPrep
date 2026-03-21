package com.certprep.certprep.question.repository;

import com.certprep.certprep.question.entity.QuestionBK;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionBckRepository extends JpaRepository<QuestionBK, Long> {
}
