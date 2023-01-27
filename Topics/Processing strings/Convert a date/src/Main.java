import java.util.Scanner;
import java.util.Arrays;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split("-");
        System.out.println(str[1]+"/"+ str[2]+"/"+ str[0]);


    }
}