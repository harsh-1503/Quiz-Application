package com.harsh.QuizApplication.models;


import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class QuestionWrapper {
    private Integer id;
    public String language;
    private String question;
    private String option1;

    public QuestionWrapper(Integer id, String language, String question, String option1, String option2, String option3, String option4) {
        this.id = id;
        this.language = language;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
    }

    private String option2;
    private String option3;
    private String option4;
}
