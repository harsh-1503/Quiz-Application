package com.harsh.QuizApplication.service;


import com.harsh.QuizApplication.dao.QuestionDao;
import com.harsh.QuizApplication.dao.QuizDao;
import com.harsh.QuizApplication.models.Question;
import com.harsh.QuizApplication.models.QuestionWrapper;
import com.harsh.QuizApplication.models.Quiz;
import com.harsh.QuizApplication.models.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service

public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> createQuiz(String language,int numq, String title){

        List<Question> listQuestions = questionDao.selectRandomAndCategory(language, numq);
        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(listQuestions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Your Quiz is Ready", HttpStatus.OK);
    }



    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
         Optional<Quiz> quiz =  quizDao.findById(id);
         List<Question> questionsFromDB = quiz.get().getQuestions();
         List<QuestionWrapper> questionForUser = new ArrayList<>();
         for(Question q:questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestion(), q.getOption1(), q.getOption2(),q.getOption3(),q.getOption4(),q.getAnswer());
            questionForUser.add(qw);
         }
         return new ResponseEntity<>(questionForUser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> submitQuiz(Integer id, List<Response> responses) {
        Optional<Quiz> q = Optional.of(quizDao.findById(id).get());
        List<Question> questions = q.get().getQuestions();
        Integer count = 0;
        for(Response r:responses){
            if(r.getResponse().equals(questions.get(i).getAnswer())){
                count++;
            }
        }

        return new ResponseEntity<>(count,HttpStatus.OK);

        for(Response r:responses){
            if(r.)
        }
    }
}
