package chapter12_exception_handling_and_text_io.listing;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Listing12_17_ReadFileFromUrl {
    public static void main(String[] args) {
        System.out.println("Enter a URL: ");
        String URLString = new Scanner(System.in).next();

        try {
            URL url = new URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }
            System.out.println("The file size is  " + count + " characters");
        } catch (MalformedURLException ex) {
            System.out.println(ex + " Invalid URL");
        } catch (IOException ex) {
            System.out.println(ex + " I/O Errors: no such file");
        }
    }
}
