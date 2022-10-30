package Module11;
import java.util.List;
import java.util.stream.Collectors;

public class Lab11_2 {

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

        return (String) namesList.stream()
                .sorted(((n1, n2) -> n2.compareTo(n1)))
                .map(o -> o.toUpperCase())
                .collect(Collectors.joining(", "));
    }

}
