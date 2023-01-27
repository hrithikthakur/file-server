import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Stream;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        long num = reader.lines().flatMap(s -> Stream.of(s.split("\\s+")))
                                 .map(String::trim)
                                 .filter(s -> !s.isEmpty())
                                 .count();
        System.out.println(num);

//        Another method
       /* Scanner scanner = new Scanner(System.in);
        System.out.println(scanner.tokens().count());*/

        reader.close();
    }
}
