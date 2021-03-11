package BOJ.JGeun.p1900;

import java.util.Scanner;

public class BOJ1934 {
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return Math.abs(a);
    }

    public static int lcm(int a, int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=0; i<T; i++){
            int A = sc.nextInt();
            int B = sc.nextInt();

            System.out.println(lcm(A,B));
        }
    }
}
