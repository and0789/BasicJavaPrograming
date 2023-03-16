package chapter12_exception_handling_and_text_io.listing;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class Listing12_16_ReplaceText {
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 4) {
            System.out.println("Usage: java replaceText sourceFile targetFile oldStr newStr");
            System.exit(1);
        }

        // Check if source file exist
        File sourceFile = new File(args[0]);
        if (!sourceFile.exists()) {
            System.out.println("Source file " + args[0] + " does not exist");
            System.exit(2);
        }

        // Check if target file already exist
        File targetFile = new File(args[1]);
        if (sourceFile.exists()) {
            System.out.println("Target file " + args[1] + " already exist");
        }

        try (Scanner input = new Scanner(sourceFile); PrintWriter output = new PrintWriter(targetFile);) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                String s2 = s1.replaceAll(args[2], args[3]);
                output.println(s2);
            }
        }
    }
}
