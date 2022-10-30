package Module11;
import java.util.List;
import java.util.stream.Collectors;

public class Lab11_1 {
    public static void main(String[] args) {
        List<String> name = List.of(
                "John",
                "Alex",
                "Tim",
                "Ian"
        );

        System.out.println(noOddNamesToString(name));

    }


    public static String noOddNamesToString(List <String> namesList) {

        return namesList.stream()
                .filter(o -> (namesList.indexOf(o)+1) % 2 != 0)
                .collect(Collectors.joining(", "));
    }
}

