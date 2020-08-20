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

import java.util.Random;

@Controller
@RequestMapping("/u/definitiontest")
public class DefinitionTestController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public String goDefinitionTestPage(Model model) {
        Random random = new Random();
        model.addAttribute("randomWords", wordService.getRandomWords());
        model.addAttribute("randomNumber", random.nextInt(4));
        model.addAttribute("answerPage", false);
        return "definitionTest";
    }

    @PostMapping
    public String checkAnswer(@RequestParam("qDefiniton") String definition, @RequestParam("aWord") String word, Model model) {
        Word correctAnswer = wordService.findWordByDefinition(definition);
        model.addAttribute("correctWord", correctAnswer);
        model.addAttribute("wordLink", "https://dictionary.cambridge.org/dictionary/english/" + correctAnswer.getWord());
        model.addAttribute("answerPage", true);
        if (correctAnswer.getWord().equalsIgnoreCase(word))
            model.addAttribute("checkAnswer", true);
        else model.addAttribute("checkAnswer", false);
        return "definitionTest";
    }

}
