package com.harsh.QuizApplication.service;

import com.harsh.QuizApplication.dao.QuestionDao;
import com.harsh.QuizApplication.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestions() {
        try{
            return new ResponseEntity<>( questionDao.findAll(), HttpStatus.OK );
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
    }

    public ResponseEntity<List<Question>> getCategoryQuestions(String Language) {
        try{
            return new ResponseEntity<>(questionDao.findByLanguage(Language),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>( HttpStatus.BAD_REQUEST );
    }

    public ResponseEntity<String> addNewQuestion(Question question) {
        try{
            questionDao.save(question);
            return new ResponseEntity<>("success",HttpStatus.CREATED);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("failure",HttpStatus.BAD_REQUEST);
        }
    }
}
