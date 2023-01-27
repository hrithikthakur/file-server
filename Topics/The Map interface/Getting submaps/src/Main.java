import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int from = scanner.nextInt();
        int to = scanner.nextInt();
        int size = Integer.parseInt(scanner.next());
        SortedMap<Integer, String> map = new TreeMap<>();
        while (scanner.hasNextLine()) {
            map.put(scanner.nextInt(), scanner.next());
    }
        map.subMap(from, to + 1).forEach((key, val) -> System.out.println(key + " " + val));
}
}