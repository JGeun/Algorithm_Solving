package BOJ.JGeun.p2100;

import java.io.*;
import java.util.*;

public class BOJ2133 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[31];
    }

    static void process(){
        dp[0] = 1; dp[2] = 3;
        for(int i=4; i<=N; i++){
            for(int j=2; j<=i; j+=2) {
                int standard = j == 2 ? 3 : 2;
                dp[i] += standard*dp[i-j];
            }
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
