import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // start coding here
        String text = reader.readLine();
        StringBuilder sb = new StringBuilder(text);
        System.out.println(sb.reverse());


        reader.close();
    }
}