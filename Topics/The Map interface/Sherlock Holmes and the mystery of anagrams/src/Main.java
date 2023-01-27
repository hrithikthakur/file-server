import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] word1 = scanner.nextLine().toLowerCase().split("");
        String[] word2 = scanner.nextLine().toLowerCase().split("");
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String str : word1) {
            if (map1.containsKey(str)) {
                map1.put(str, map1.get(str) + 1);
            } else {
                map1.put(str, 1);
            }
        }
        for (String str : word2) {
            if (map2.containsKey(str)) {
                map2.put(str, map2.get(str) + 1);
            } else {
                map2.put(str, 1);
            }
        }
        System.out.println(Objects.equals(map1, map2) ? "yes" : "no");
    }
}