package com.forfuture.repeatsecurity.controllers.formContollers;

import com.forfuture.repeatsecurity.entities.Word;
import com.forfuture.repeatsecurity.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/a/word_add")
public class WordFormController {

    @Autowired
    private WordService wordService;

    @GetMapping
    public String getWordAdd(Model model) {
        model.addAttribute("newWord", new Word());
        return "/admin/wordAdd";
    }


    @PostMapping
    public String postWordAdd(Word word, Model model) {
        wordService.saveWord(word);
        model.addAttribute("newWord", new Word());
        return "/admin/wordAdd";
    }

}
