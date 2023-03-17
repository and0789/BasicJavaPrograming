package chapter12_exception_handling_and_text_io.exercise;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_12_23_ProcessScoreInATextFileOnTheWeb {
    public static void main(String[] args) {
        ArrayList<Double> list = new ArrayList<>();

        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                list.add(input.nextDouble());
            }

            double total = sum(list);
            System.out.printf("Total scores: %.0f\n", total);
            System.out.printf("Average scores: %.0f\n", (total / list.size()));
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
        } catch (IOException ex) {
            System.out.println("I/O Errors: so such file");
        }
    }

    private static double sum(ArrayList<Double> list) {
        double sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i);
        }

        return sum;
    }
}
