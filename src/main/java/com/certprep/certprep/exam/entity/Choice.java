package com.certprep.certprep.exam.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="choices")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long questionId;

    private String choiceText;

    private Boolean correct;
}
