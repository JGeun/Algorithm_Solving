package BOJ.p2200;

import java.util.*;
import java.io.*;

public class BOJ2225 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K;
    static int[] dp;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[N+1];
    }

    static void process() {
        for(int i=1; i<=K; i++){
            dp[1] = i;
            for(int j=2; j<=N; j++){
                dp[j] = (dp[j-1]+dp[j])%1000000000;
            }
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
