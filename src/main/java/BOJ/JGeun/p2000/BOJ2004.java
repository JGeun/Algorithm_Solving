package BOJ.JGeun.p2000;

import java.util.Scanner;

public class BOJ2004 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long two = 0;
        long five = 0;

        two = getTwoDivisorCount(n) - getTwoDivisorCount(n - m) - getTwoDivisorCount(m);
        five = getFiveDivisorCount(n) - getFiveDivisorCount(n - m) - getFiveDivisorCount(m);
        System.out.println(Math.min(two, five));
    }

    public static long getFiveDivisorCount(int n) {
        long count = 0;
        for (long i = 2; i <= n; i *= 2) {
            count += n / i;
        }
        return count;
    }

    public static long getTwoDivisorCount(int n) {
        long count = 0;
        for (long i = 5; i <= n; i *= 5) {
            count += n / i;
        }
        return count;
    }
}
