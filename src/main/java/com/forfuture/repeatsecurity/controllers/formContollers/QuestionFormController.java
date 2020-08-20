package com.forfuture.repeatsecurity.controllers.formContollers;


import com.forfuture.repeatsecurity.entities.Question;
import com.forfuture.repeatsecurity.entities.Word;
import com.forfuture.repeatsecurity.services.QuestionService;
import com.forfuture.repeatsecurity.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/a/question_add")
public class QuestionFormController {

    @Autowired
    private WordService wordService;

    @Autowired
    private QuestionService questionService;

    @GetMapping
    public String goQuestionAddPage() {
        return "/admin/questionAdd";
    }

    @PostMapping
    public String addNewQuestion(Model model, @RequestParam("question") String question, @RequestParam("answer") String answer) {
        Word word = wordService.getWord(answer);
        if (word == null) {
            model.addAttribute("wrongWord", true);
            return "/admin/questionAdd";
        }
        Question question1 = new Question(question, word);
        if (questionService.saveQuestion(question1)) model.addAttribute("success", true);
        else model.addAttribute("success",false);
        return "/admin/questionAdd";
    }

}
