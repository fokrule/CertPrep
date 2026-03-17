package com.certprep.certprep.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="exams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

}