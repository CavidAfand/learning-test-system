package com.forfuture.repeatsecurity.services;

import com.forfuture.repeatsecurity.entities.Question;
import com.forfuture.repeatsecurity.repositories.QuestionRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public boolean saveQuestion(Question question) {
        try {
            questionRepository.save(question);
            return true;
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Question> getRandomQuestions() {
        List<Question> allQuestions = questionRepository.findAll();
        List<Question> randomQuestion = new ArrayList<>();
        Random random = new Random();
        for (int i=0; i < 4; i++) {
            randomQuestion.add(allQuestions.remove(random.nextInt(allQuestions.size())));
        }
        return randomQuestion;
    }

    public Question findQuestion(String questionText) {
        try {
            Question question = questionRepository.findByQuestion(questionText);
            return question;
        }
        catch (Exception ex) {
            log.error("Error happened, there isn't searched question in database");
            return null;
        }
    }

}
