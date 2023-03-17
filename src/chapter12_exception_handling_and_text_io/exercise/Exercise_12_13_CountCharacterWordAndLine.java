package chapter12_exception_handling_and_text_io.exercise;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.Scanner;

public class Exercise_12_13_CountCharacterWordAndLine {
    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.out.println("Usage: java Exercise_12_13_CountCharacterWordAndLine fileName");
            System.exit(1);
        }

        File file = new File(args[0]);
        if (!file.exists()) {
            System.out.println("File " + args[0] + " does not exist");
            System.exit(2);
        }

        int character = 0;
        int words = 0;
        int lines = 0;

        try (Scanner input = new Scanner(file)){
            while (input.hasNext()) {
                lines++;
                String line = input.nextLine();
                character += line.length();
            }
        }

        try (Scanner input = new Scanner(file)){
            while (input.hasNext()) {
                String line = input.next();
                words++;
            }
        }

        System.out.println("File " + file.getName() + " has");
        System.out.println(character + " characters");
        System.out.println(words + " words");
        System.out.println(lines + " lines");
    }
}
