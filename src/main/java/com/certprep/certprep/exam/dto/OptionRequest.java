package com.certprep.certprep.exam.dto;

import jakarta.validation.constraints.NotBlank;

public class OptionRequest {

    @NotBlank
    private String text;

    private boolean isCorrect;

    public String getText() {
        return text;
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setIsCorrect(boolean correct) {
        isCorrect = correct;
    }
}
