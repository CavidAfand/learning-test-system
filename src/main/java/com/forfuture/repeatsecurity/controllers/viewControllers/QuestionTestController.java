package com.forfuture.repeatsecurity.controllers.viewControllers;

import com.forfuture.repeatsecurity.entities.Question;
import com.forfuture.repeatsecurity.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/u/question_test")
public class QuestionTestController {

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String goQuestionTestPage(Model model) {
        List<Question> randomQuestions = questionService.getRandomQuestions();
        Random random = new Random();
        model.addAttribute("randomQuestions", randomQuestions);
        model.addAttribute("randomNumber", random.nextInt(4));
        model.addAttribute("answerPage", false);
        return "questionTest";
    }


    @PostMapping
    public String checkAnswer(Model model, @RequestParam("qSentence") String qSentence, @RequestParam("qAnswer") String userAnswer) {
//        Question question = questionService.findQuestion(qSentence);
//        if (question.getAnswer().getWord().equalsIgnoreCase(userAnswer)) {
//            model.addAttribute("correctAnswer", true);
//        }
//        else model.addAttribute("correctAnswer", false);
        List <Question> allQuestion = questionService.getAllQuestions();
        Question question = allQuestion.stream().filter(i -> i.getAnswer().getWord().equalsIgnoreCase(userAnswer)).findFirst().get();
        if (question != null) model.addAttribute("correctAnswer", true);
        else model.addAttribute("correctAnswer", false);
        model.addAttribute("answerPage", true);
        model.addAttribute("answer", question);
        model.addAttribute("wordLink", "https://dictionary.cambridge.org/dictionary/english/" + question.getAnswer().getWord());
        return "questionTest";
    }


}
