package Module11;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class Lab11_5 {

    public static void main(String[] args) {
        Stream <String> firstMas = Stream.of("1", "2", "3");
        Stream <String> secondMas = Stream.of("q", "w", "e", "r");
        zip(firstMas, secondMas)
                .peek(System.out::println)
                .collect(Collectors.toList());
    }

    public static <T> Stream <T> zip(Stream <T> firstMas, Stream<T> secondMas) {
        Iterator<T> firstIterator = firstMas.iterator();
        Iterator<T> secondIterator = secondMas.iterator();
        List<T> result = new ArrayList<>();
        while (firstIterator.hasNext() && secondIterator.hasNext()) {
            result.add(firstIterator.next());
            result.add(secondIterator.next());
        }
        return result.stream();
    }

}
