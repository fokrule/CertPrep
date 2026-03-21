package com.certprep.certprep.exam.dto;


import com.certprep.certprep.exam.entity.QuestionType;
import jakarta.validation.constraints.*;
import java.util.List;

public class QuestionRequest {

    @NotNull
    private Long examId;

    @NotBlank
    private String questionText;

    @NotNull
    private QuestionType type;

    @NotEmpty
    private List<OptionRequest> options;

    public Long getExamId() {
        return examId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public QuestionType getType() {
        return type;
    }

    public List<OptionRequest> getOptions() {
        return options;
    }

    public void setExamId(Long examId) {
        this.examId = examId;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setOptions(List<OptionRequest> options) {
        this.options = options;
    }
}
