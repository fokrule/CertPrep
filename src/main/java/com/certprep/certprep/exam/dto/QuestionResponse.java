package com.certprep.certprep.exam.dto;


import com.certprep.certprep.exam.entity.QuestionType;
import java.util.List;

public class QuestionResponse {

    private Long id;
    private String questionText;
    private QuestionType type;
    private List<OptionResponse> options;

    public Long getId() {
        return id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public QuestionType getType() {
        return type;
    }

    public List<OptionResponse> getOptions() {
        return options;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public void setType(QuestionType type) {
        this.type = type;
    }

    public void setOptions(List<OptionResponse> options) {
        this.options = options;
    }
}
