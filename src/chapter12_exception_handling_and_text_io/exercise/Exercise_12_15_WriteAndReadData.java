package chapter12_exception_handling_and_text_io.exercise;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Exercise_12_15_WriteAndReadData {
    public static void main(String[] args) throws Exception {
        File file = new File("Exercise_12_15.txt");
        if (file.exists()) {
            System.out.println("File " + file.getName() + " already exist");
            System.exit(0);
        }

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 0; i < 100; i++) {
                output.print((int) (Math.random() * 500) + 1);
                output.print(" ");
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                list.add(input.nextInt());
            }
        }

        Collections.sort(list);

        System.out.println(list.toString());
        System.out.println();
    }
}
