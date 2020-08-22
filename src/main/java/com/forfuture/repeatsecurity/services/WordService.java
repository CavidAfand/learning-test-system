package com.forfuture.repeatsecurity.services;

import com.forfuture.repeatsecurity.entities.Word;
import com.forfuture.repeatsecurity.repositories.WordRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public boolean saveWord(Word word) {
        try {
            wordRepository.save(word);
            return true;
        }
        catch (Exception ex) {
//            ex.printStackTrace();
            log.error("Error happened when new word was added to database");
            return false;
        }
    }

    public List<Word> getRandomWords() {
        List <Word> words = wordRepository.findAll();
        List <Word> randomWords = new ArrayList<>();
        for (int i=0; i<4; i++) {
            Random random = new Random();
            int index = random.nextInt(words.size());
            randomWords.add(words.remove(index));
        }

        return randomWords;
    }

    public Word getWord(String word) {
        try {
            Word packet = wordRepository.findById(word).get();
            return packet;
        }
        catch (Exception ex) {
//            ex.printStackTrace();
            log.error("Error happened, because searched word doesn't exist in database");
            return null;
        }
    }

    public Word findWordByDefinition(String definition) {
        List <Word> allWords = wordRepository.findAll();
        return allWords.stream().filter(i -> i.getDefinition().equalsIgnoreCase(definition)).findFirst().get();
//        return packet;
    }



}
