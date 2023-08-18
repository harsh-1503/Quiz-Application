package com.harsh.QuizApplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity

public class Question {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    //We want the id to be auto generated
    private Integer id;
    public String language;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String difficulty;
    private String answer;

}
