package chapter12_exception_handling_and_text_io.listing;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Listing12_13_WriteData {
    public static void main(String[] args) throws IOException {
        File file = new File("scores.txt");
        if (file.exists()) {
            System.out.println("File already exists");
            System.exit(1);
        }

        PrintWriter output = new PrintWriter(file);

        output.print("Andre Septian");
        output.println(90);
        output.print("Hera Herliana");
        output.println(85);

        output.close();
    }
}
