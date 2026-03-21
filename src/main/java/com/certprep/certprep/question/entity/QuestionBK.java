package com.certprep.certprep.question.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="questionsbk")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionBK {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long examId;

    private String questionText;

}