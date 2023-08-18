package com.harsh.QuizApplication.dao;

import com.harsh.QuizApplication.models.Question;
import com.harsh.QuizApplication.models.Quiz;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface QuizDao extends JpaRepository<Quiz,Integer> {


}
