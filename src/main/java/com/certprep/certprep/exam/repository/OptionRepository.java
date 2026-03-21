package com.certprep.certprep.exam.repository;


import com.certprep.certprep.exam.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Long> {
}
