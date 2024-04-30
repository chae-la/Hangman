package org.example;

import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);

    public char getUserInput(){
        char userGuess;
        do {
            System.out.println("Guess a letter");
            String input = scanner.nextLine().toUpperCase();
            if (input.length() != 1 || !input.matches("[A-Z]")) {
                System.out.println("GUESS. A. SINGLE. LETTER.");
                continue;
            }
            userGuess = input.charAt(0);
            break;
        } while (true);
        return userGuess;
    }

    public void closeScanner() {
        scanner.close();
    }
}
