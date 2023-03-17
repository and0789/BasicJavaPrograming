package chapter12_exception_handling_and_text_io.exercise;

import com.sun.source.tree.WhileLoopTree;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Exercise_12_11_RemoveText {
    public static void main(String[] args) throws Exception {
        // Check command line parameter usage
        if (args.length != 2) {
            System.out.println("Usage: java programName.java removeText fileName");
            System.exit(1);
        }

        // Check if file exist
        File file = new File(args[1]);
        if (!file.exists()) {
            System.out.println("File " + args[1] + " does not exist");
            System.exit(2);
        }

        // create an ArrayList
        ArrayList<String> s2 = new ArrayList<>();
        try (
                Scanner input = new Scanner(file);
                ) {
            while (input.hasNext()) {
                String s1 = input.nextLine();
                s2.add(removeString(args[0], s1));
            }
        }

        try (
                PrintWriter output = new PrintWriter(file);
                ){
            for (int i = 0; i < s2.size(); i++) {
                output.println(s2.get(i));
            }
        }
    }

    private static String removeString(String arg, String line) {
        StringBuilder stringBuilder = new StringBuilder(line);
        int start = stringBuilder.indexOf(arg);
        int end = arg.length();

        while (start >= 0) {
            end = start + end;
            stringBuilder = stringBuilder.delete(start, end);
            start = stringBuilder.indexOf(arg, start);
        }
        return stringBuilder.toString();
    }
}
