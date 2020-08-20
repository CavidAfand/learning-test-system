package com.forfuture.repeatsecurity.controllers.viewControllers;

import com.forfuture.repeatsecurity.entities.Word;
import com.forfuture.repeatsecurity.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.Random;

@Controller
@RequestMapping("/u/wordtest")
public class WordTestController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public String goWordTestPage(Model model) {
        Random random = new Random();
        model.addAttribute("randomWords", wordService.getRandomWords());
        model.addAttribute("randomNumber", random.nextInt(4));
        model.addAttribute("answerPage", false);
        return "wordTest";
    }

    @PostMapping
    public String checkAnswer(@RequestParam("qWord") String word, @RequestParam("aDefinition") String definition, Model model) {
        Word correctAnswer = wordService.getWord(word);
        model.addAttribute("correctWord", correctAnswer);
        model.addAttribute("answerPage", true);
        model.addAttribute("wordLink", "https://dictionary.cambridge.org/dictionary/english/" + correctAnswer.getWord());
        if (correctAnswer.getDefinition().equalsIgnoreCase(definition)) {
            model.addAttribute("checkAnswer", true);
        }
        else {
            model.addAttribute("checkAnswer", false);
        }
        return "wordTest";
    }

}
