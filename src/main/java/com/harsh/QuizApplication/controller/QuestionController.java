package com.harsh.QuizApplication.controller;


import com.harsh.QuizApplication.models.Question;
import com.harsh.QuizApplication.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestions(){
        return questionService.getAllQuestions();
    }

    @GetMapping("/category/{Language}")
    public ResponseEntity<List<Question>> getCategoryQuestions(@PathVariable("Language") String Language){
        return questionService.getCategoryQuestions(Language);
    }
    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addNewQuestion(question);
    }
}
