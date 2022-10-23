package Module10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumbers {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            InputStream inputStream = new FileInputStream("file1.txt");
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                Matcher num = Pattern.compile("^?((\\(\\d{1,3}\\))|\\d{1,3})[- ]?\\d{3,4}[-]?\\d{4}$").matcher(line);
                if (num.find() != false) {
                    System.out.println(line);
                }
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

}
