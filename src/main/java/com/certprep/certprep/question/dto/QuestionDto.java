package com.certprep.certprep.question.dto;

import com.certprep.certprep.category.dto.CategoryDto;
import com.certprep.certprep.category.entity.Category;

public class QuestionDto {
    private Long id;
    private String question;
    private String explanation;
    private CategoryDto category;

    public QuestionDto(){}

    public QuestionDto(Long id, String question, String explanation, CategoryDto category){
        this.id = id;
        this.question = question;
        this.explanation = explanation;
        this.category = category;
    }

    public Long getId(){return id;}
    public void setId(Long id){
            this.id = id;
    }

    public String getQuestion(){return question;}
    public void setQuestion(String question){
        this.question = question;
    }

    public String getExplanation(){return explanation;}
    public void setExplanation(String explanation){this.explanation = explanation;}

    public CategoryDto getCategory(){return category;}
    public void setCategory(CategoryDto category){this.category = category;}

}
