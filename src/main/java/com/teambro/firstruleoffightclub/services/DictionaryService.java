package com.teambro.firstruleoffightclub.services;

import com.teambro.firstruleoffightclub.repositories.DictionaryRepository;
import com.teambro.firstruleoffightclub.repositories.URLRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by zac on 1/23/17.
 */
@Service
public class DictionaryService {
    private final DictionaryRepository dictionaryRepository;
    private final URLRepository urlRepository;

    @Autowired
    public DictionaryService(DictionaryRepository dictionaryRepository, URLRepository urlRepository) {
        this.dictionaryRepository = dictionaryRepository;
        this.urlRepository = urlRepository;
    }

    public String generateURL(int numberOfAdjectives){
        return generateAdjectives(numberOfAdjectives) + generateNoun();
    }

    private String generateAdjectives(int amount){
        String adjectives = "", temp;

        for (int i=0; i < amount; i++){
            temp = dictionaryRepository.getRecord(getRandomNumber(0, dictionaryRepository.getHighestAdjective()));
            adjectives += temp.substring(0, 1).toUpperCase() + temp.substring(1);;
        }

        return adjectives;
    }

    private String generateNoun(){
        String temp = dictionaryRepository.getRecord(getRandomNumber(dictionaryRepository.getHighestAdjective() + 1, dictionaryRepository.getHighestNoun()));
        return temp.substring(0, 1).toUpperCase() + temp.substring(1);
    }

    public int getRandomNumber(int lowest, int highest){
        return new Random().nextInt(highest - lowest) + lowest;
    }

}
