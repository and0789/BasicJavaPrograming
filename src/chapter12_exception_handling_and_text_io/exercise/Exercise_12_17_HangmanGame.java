package chapter12_exception_handling_and_text_io.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_12_17_HangmanGame {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(System.in);

        String play;
        do {
            char[] word = getWord();

            char[] asterisks = new char[word.length];
            fileAsterisks(asterisks);

            int missed = 0;
            do {
                char guess = getGuess(asterisks);

                if (!isCorrectGuess(word, asterisks, guess)) {
                    missed++;
                }
            } while (!isWordFinish(asterisks));

            print(word, missed);

            System.out.println("Do you want to guess another word? Enter y or n");
            play = input.next();
        } while (play.charAt(0) == 'y');
    }

    private static char getGuess(char[] asterisks) {
        Scanner input = new Scanner(System.in);
        System.out.print("(Guess) Enter a letter in word ");
        System.out.print(asterisks);
        System.out.print(" > ");
        String g = input.next();

        return g.charAt(0);
    }

    private static void print(char[] word, int missed) {
        System.out.println("The word is ");
        System.out.println(word);
        System.out.println(" You missed " + missed + (missed > 1 ? " times" : " time"));
    }

    private static void print(int m, char guess) {
        System.out.println("\t" + guess);
        switch (m) {
            case 1 -> System.out.println(" is already in the word");
            case 2 -> System.out.println(" is not in the word");
        }
    }

    private static boolean isWordFinish(char[] blanks) {
        for (char e: blanks) {
            if (e == '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean isCorrectGuess(char[] word, char[] blanks, char guess) {
        boolean correct = false;
        int message = 2;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == guess) {
                correct = true;
                if (blanks[i] == guess) {
                    message = 1;
                } else {
                    blanks[i] = guess;
                    message = 0;
                }
            }
        }
        if (message > 0) {
            print(message, guess);
        }
        return correct;
    }

    private static void fileAsterisks(char[] list) {
        for (int i = 0; i < list.length; i++) {
            list[i] = '_';
        }
    }

    private static char[] getWord() throws FileNotFoundException {
        File file = openFile();

        ArrayList<String> words = new ArrayList<>();
        try (Scanner input = new Scanner(file)){
            while (input.hasNext()) {
                words.add(input.next());
            }
        }

        String pick = words.get((int)(Math.random() * words.size()));
        char[] word = pick.toCharArray();

        return word;
    }

    private static File openFile() throws FileNotFoundException {
        File file = new File("hangman.txt");

        if (!file.exists()) {
            System.out.println("File " + file.getName() + " does not exist");
            System.exit(1);
        }
        return file;
    }
}
