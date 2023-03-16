package chapter12_exception_handling_and_text_io.listing;

import java.io.File;
import java.util.Scanner;

public class Listing12_15_ReadData {
    public static void main(String[] args) throws Exception {
        File file = new File("scores.txt");

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String firstName = input.next();
            String lastName = input.next();
            int score = input.nextInt();
            System.out.println(firstName + " " + lastName + ", score : " + score );
        }

        input.close();
    }
}
