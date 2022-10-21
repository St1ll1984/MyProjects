package Module10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class JsonConvertor {

    public static void main(String[] args) throws IOException {
        ArrayList<ObjectToJson> list = new ArrayList<>();
        try {
            InputStream inputStream = new FileInputStream("file.txt");
            Scanner scanner = new Scanner(inputStream);
            scanner.nextLine();
            while (scanner.hasNext()) {
                String[] masLine = scanner.nextLine().split(" ");
                list.add(new ObjectToJson(masLine[0], masLine[1]));
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println(list.toString());

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter fw = new FileWriter("peoples.json");
        gson.toJson(list,fw);
        fw.flush();
        fw.close();

    }
}



