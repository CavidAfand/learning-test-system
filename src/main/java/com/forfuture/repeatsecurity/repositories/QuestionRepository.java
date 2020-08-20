package com.forfuture.repeatsecurity.repositories;

import com.forfuture.repeatsecurity.entities.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

    Question findByQuestion(String question);

}
