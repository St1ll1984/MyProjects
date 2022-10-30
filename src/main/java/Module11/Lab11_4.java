package Module11;
import java.util.stream.LongStream;

public class Lab11_4 {

    public static void main(String[] args) {
        long a = 25214903917l;
        long c = 11l;
        long m = (long) Math.pow(2, 48);

        MyRandom myRandom = new MyRandom(a, c, m);
        LongStream myStream = LongStream.iterate(1, (seed) -> myRandom.seed(seed).next());
        myStream.limit(5)
                .forEach(System.out::println);
    }

}