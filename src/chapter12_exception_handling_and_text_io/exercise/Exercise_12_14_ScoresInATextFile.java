package chapter12_exception_handling_and_text_io.exercise;

import java.io.File;
import java.util.Scanner;

public class Exercise_12_14_ScoresInATextFile {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a file of score ");
        File file = new File(input.nextLine());

        if (!file.exists()) {
            System.out.println("File " + file + " does not exist");
            System.exit(1);
        }

        int count = 0;
        double total = 0;

        try (Scanner inputFile = new Scanner(file)){
            while (inputFile.hasNext()) {
                total += inputFile.nextInt();
                count++;
            }
        }
        System.out.println("File " + file.getName());
        System.out.println("Total scores " + total);
        System.out.println("Average scores " + (total / count));
    }
}
