package org.example;

import java.util.HashSet;
import java.util.Set;

public class Display {

    private final RandomWord randomWord = new RandomWord();
    private final UserInput userInput = new UserInput();
    private int livesCounter = 8;
    private final Set<Character> guesses = new HashSet<>();
    private final Figure figure = new Figure();
    private boolean replay = true;

    public String coveredWord() {
        String underscore = new String(new char[randomWord.getRandomWord().length()]).replace('\0', '_');
        return underscore;
    }

    public int getLivesCounter() {
        return livesCounter;
    }

    public void setLivesCounter(int livesCounter) {
        this.livesCounter = livesCounter;
    }

    public void playHangman() {
        System.out.println("Welcome to Hangman");
        String wordToGuess = randomWord.getRandomWord();
        String currentWord = coveredWord();
        boolean replay = true;

        while (replay) {
            livesCounter = 8;
            guesses.clear();

            while (livesCounter > 0 && currentWord.contains("_")) {
                System.out.println(currentWord);
                System.out.println("Lives Left: " + livesCounter);

                char userGuess = userInput.getUserInput();
                if (guesses.contains(userGuess)) {
                    System.out.println("You already guessed '" + userGuess + "'. Guess again.");
                    continue;
                }
                guesses.add(userGuess);

                if (wordToGuess.indexOf(userGuess) == -1) {
                    System.out.println("'" + userGuess + "' is not in the word.");
                    livesCounter--;
                    figure.hangmanFigure(livesCounter);
                } else {
                    System.out.println("Correct guess!");

                    StringBuilder updatedWord = new StringBuilder(currentWord);
                    for (int i = 0; i < wordToGuess.length(); i++) {
                        if (wordToGuess.charAt(i) == userGuess) {
                            updatedWord.setCharAt(i, userGuess);
                        }
                    }
                    currentWord = updatedWord.toString();
                }
            }

            if (livesCounter == 0) {
                System.out.println("You ran out of lives. The word was: " + wordToGuess);
            } else {
                System.out.println("Congratulations! You guessed the word: " + currentWord);
            }

            System.out.println("Replay? (y/n)");
            char replayChoice = userInput.getUserInput();
            replay = (replayChoice == 'y' || replayChoice == 'Y');
            if (replay) {
                wordToGuess = randomWord.getRandomWord();
                currentWord = coveredWord();
            }
        }
        System.out.println("Thank you for playing!");
    }
}



