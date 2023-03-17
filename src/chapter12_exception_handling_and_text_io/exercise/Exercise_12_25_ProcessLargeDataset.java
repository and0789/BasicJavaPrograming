package chapter12_exception_handling_and_text_io.exercise;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_12_25_ProcessLargeDataset {
    public static void main(String[] args) {
        ArrayList<Double> assistant = new ArrayList<>();
        ArrayList<Double> associate = new ArrayList<>();
        ArrayList<Double> full = new ArrayList<>();

        try {
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Salary.txt");
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String[] line = (input.nextLine()).split(" ");
                processData(assistant,
                        associate,
                        full,
                        line[2],
                        new Double(line[3]));
            }
        } catch (MalformedURLException ex) {
            System.out.println("Invalid URL");
            System.exit(0);
        } catch (IOException ex) {
            System.out.println("I/O Errors: no such file");
            System.exit(1);
        }

        double totalAssistant = getTotal(assistant);
        double totalAssociate = getTotal(associate);
        double totalFull = getTotal(full);
        double totalFaculty = (totalAssistant + totalAssociate + totalFull);

        System.out.println("\n      Total Salary");
        System.out.println("------------------------------");
        System.out.printf("Assistant professors : $%.2f\n", totalAssistant);
        System.out.printf("Associate professors : $%.2f\n", totalAssociate);
        System.out.printf("Full professors      : $%.2f\n", totalFull);
        System.out.printf("All Faculty          : $%.2f\n", totalFaculty);

        System.out.println("\n      Average Salary");
        System.out.printf("Assistant professors : $%.2f\n", (totalAssistant / assistant.size()));
        System.out.printf("Associate professors : $%.2f\n", (totalAssociate / associate.size()));
        System.out.printf("Full professors      : $%.2f\n", (totalFull / full.size()));
        System.out.printf("All Faculty          : $%.2f\n", (totalFaculty / (assistant.size() + associate.size() + full.size())));
    }

    private static void processData(ArrayList<Double> assistant, ArrayList<Double> associate, ArrayList<Double> full, String rank, Double salary) {
        if (rank.equals("assistant")) {
            assistant.add(salary);
        } else if (rank.equals("associate")) {
            associate.add(salary);
        } else if (rank.equals("full")) {
            full.add(salary);
        }
    }

    private static double getTotal(ArrayList<Double> list) {
        double total = 0;
        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
        }
        return total;
    }
}
