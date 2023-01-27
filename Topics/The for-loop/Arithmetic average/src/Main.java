import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // start coding here
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0, sum = 0;
        for (int i = a; i <= b; i++){
            if (i%3 == 0){
                sum += i;
                count++;
            }
        }

        double ans = (double) sum/ count;
        System.out.println(ans);

    }
}
