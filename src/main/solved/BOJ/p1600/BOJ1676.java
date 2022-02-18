package BOJ.p1600;

import java.util.Scanner;

public class BOJ1676 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int two = 0;
        int five = 0;
        for(int i=2; i<=N; i*=2)
            two += N/i;

        for(int i=5; i<=N; i*=5)
            five += N/i;

        if (two > five) {
            System.out.println(five);
        } else {
            System.out.println(two);
        }
    }
}
