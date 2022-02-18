package BOJ.p11000;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ11051 {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N =  sc.nextInt();
        int K = sc.nextInt();
        dp = new int[N + 1][K + 1];
        for(int i=0; i<N+1; i++)
            Arrays.fill(dp[i], 0);

        System.out.println(getBC(N, K));
    }

    public static int getBC(int N, int K){
        if(dp[N][K] > 0)
            return dp[N][K];
        else if(N == K || K == 0)
            return dp[N][K] = 1;
        else
            return dp[N][K] = (getBC(N-1, K-1) + getBC(N-1,K)) % 10007;
    }
}
