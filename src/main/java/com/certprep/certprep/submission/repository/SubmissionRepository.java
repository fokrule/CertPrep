package com.certprep.certprep.submission.repository;


import com.certprep.certprep.submission.entity.Submission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
}
