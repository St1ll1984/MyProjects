package Module13;

import java.io.IOException;
import java.util.Scanner;


public class Lab13_2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.print("Input user number: ");
        int userNumber = in.nextInt();

        new ReadAndWriteFile(userNumber);
    }
}
