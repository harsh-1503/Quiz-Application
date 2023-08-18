package com.harsh.QuizApplication.controller;


import com.harsh.QuizApplication.models.Question;
import com.harsh.QuizApplication.models.QuestionWrapper;
import com.harsh.QuizApplication.models.Response;
import com.harsh.QuizApplication.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")

public class QuizController {
    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuizes(@RequestParam String language,@RequestParam int numq,@RequestParam String title){
        return quizService.createQuiz(language,numq,title);
    }

    @GetMapping("/getQuiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.submitQuiz(id,responses);
    }
}
