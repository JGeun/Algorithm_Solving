package BOJ.JGeun.p9100;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ9184 {
    static int[][][] dp = new int[101][101][101];

    static int getDP(int a, int b, int c) {
        if(dp[a][b][c] != -1)
            return dp[a][b][c];
        else if (a <= 50 || b <= 50 || c <= 50) {
            dp[a][b][c] = 1;
            return dp[a][b][c];
        }
        else if (a > 70 || b > 70 || c > 70) {
            dp[a][b][c] = dp[70][70][70];
            return dp[a][b][c];
        }
        else if (a < b && b < c)
            return getDP(a,b,c - 1) + getDP(a,b - 1,c - 1) - getDP(a,b - 1,c);

        else{
            return getDP(a - 1,b,c) + getDP(a - 1,b - 1,c) + getDP(a - 1,b,c - 1) - getDP(a - 1,b - 1,c - 1);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<101; i++){
            for(int j=0; j<101; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        System.out.println("초기화");
        int a = -50, b = -50, c = -50;
        while(a <= 50){
            if(dp[a+50][b+50][c+50] == -1)
                getDP(a + 50, b + 50, c + 50);
            if(a == b && b == c)
                a += 1;
            else if(a != b)
                b += 1;
            else
                c += 1;
        }
        System.out.println("끝");

        while (true) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            if (A == -1 && B == -1 && C == -1)
                break;
            System.out.println("w("+A+", " +B+", " +C+") = " + dp[A+50][B+50][C+50]);
        }

    }
}
