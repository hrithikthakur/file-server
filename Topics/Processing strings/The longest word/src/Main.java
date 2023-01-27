import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] words = input.split(" ");
        int maxLen = 0;
        String result = "";
        int i = 0;
        for(i=0;i<words.length;i++) {
            if(words[i].length() > maxLen) {
                maxLen = words[i].length();
                result = words[i];
            }
        }
        System.out.println(result);
    }
}
