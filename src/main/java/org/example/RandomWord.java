package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class RandomWord {
    private String[] wordOptions = {"HOSPITALS", "PREMATURE", "POD", "LITERATURE", "RHYTHM", "SQUAT" , "FLAG", "THAW", "ECONOMIST"};
    private String randomWord;

    public RandomWord() {
        Random random = new Random();
        int randomIndex = random.nextInt(wordOptions.length);
        randomWord = wordOptions[randomIndex];
    }


    public String[] getWordOptions() {
        return wordOptions;
    }

    public void setWordOptions(String[] wordOptions) {
        this.wordOptions = wordOptions;
    }

    public String getRandomWord() {
        return randomWord;
    }

    public void setRandomWord(String randomWord) {
        this.randomWord = randomWord;
    }

}
