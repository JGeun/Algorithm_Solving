package BOJ.JGeun.p1300;

import java.io.*;
import java.util.*;

public class BOJ1309 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][3];
        dp[1][0] = 1; dp[1][1] = 1; dp[1][2] = 1;
    }

    static void process(){
        for(int i=2; i<=N; i++){
            dp[i][0] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2])%9901;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2])%9901;
            dp[i][2] = (dp[i-1][0] + dp[i-1][1])%9901;
        }
        System.out.println((dp[N][0]+dp[N][1]+dp[N][2])%9901);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
