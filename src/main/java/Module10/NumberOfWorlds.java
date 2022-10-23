package Module10;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberOfWorlds {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            InputStream inputStream = new FileInputStream("words.txt");
            Scanner scanner = new Scanner(inputStream);
            Map<String, Integer> result = new HashMap<>();
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String [] data = line.split(" ");

                for (int i = 0; i < data.length; i++) {
                    String words = data[i];
                    //String c = "1";
                    Integer count = 1;
                    if (!result.containsKey(words)) {
                        result.put(words, 1);
                    } else {
                        result.put(words, result.get(words) + count);
                    }
                }
            }
            for (Map.Entry<String, Integer> me : result.entrySet()) {
                System.out.print(me.getKey() + " ");
                System.out.println(me.getValue());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
