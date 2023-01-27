import java.util.*;

class MapUtils {

    public static SortedMap<String, Integer> wordCount(String[] strings) {
        // write your code here
        SortedMap<String, Integer> res = new TreeMap<>();
        for (String string : strings) {
            if (res.containsKey(string)) {
                res.put(string, res.get(string) + 1);
            } else {
                res.put(string,1);
            }
        }
        return res;

    }

    public static void printMap(Map<String, Integer> map) {
        // write your code here
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }

}

/* Do not change code below */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        MapUtils.printMap(MapUtils.wordCount(words));
    }
}
