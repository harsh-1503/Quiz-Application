package com.harsh.QuizApplication.dao;


import com.harsh.QuizApplication.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question,Integer> {
//    JpaRepository asks for two things....one is the table you are working with...another is the type of primary key
        List<Question> findByLanguage(String Language);

        @Query(value = "SELECT * FROM question q WHERE q.language = :language ORDER BY RAND() LIMIT :numq",nativeQuery = true)
        List<Question> selectRandomAndCategory(String language, int numq);

}
