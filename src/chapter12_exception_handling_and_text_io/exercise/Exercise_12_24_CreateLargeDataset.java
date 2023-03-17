package chapter12_exception_handling_and_text_io.exercise;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Exercise_12_24_CreateLargeDataset {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("Salary.txt");

        if (file.exists()) {
            System.out.println("File " + file.getName() + " already exist");
            System.exit(0);
        }

        String rank = "";
        double salary;

        try (PrintWriter output = new PrintWriter(file)) {
            for (int i = 1; i <= 10_000; i++) {
                output.print("FirstName" + i + " LastName" + i);
                rank = getRank();
                salary = getSalary(rank);
                output.printf(" " + rank + " %.2f\n", salary);
            }
        }
    }

    private static double getSalary(String rank) {
        if (rank.equals("assistant")) {
            return 50_000 + (Math.random() * 30_001);
        } else if (rank.equals("associate")) {
            return 60_000 + (Math.random() * 50_001);
        } else {
            return 75_000 + (Math.random() * 55_001);
        }
    }

    private static String getRank() {
        String[] ranks = {"assistant", "associate", "full"};
        return ranks[(int) (Math.random() * ranks.length)];
    }
}
