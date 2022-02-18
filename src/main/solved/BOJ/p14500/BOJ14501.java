package BOJ.p14500;

import java.io.*;
import java.util.*;

public class BOJ14501 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] T, P, dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N+5+1];
        P = new int[N+5+1];
        dp = new int[N+5+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            T[i] = t; P[i] = p;
        }
    }

    static void process(){
        int max = 0;
        for(int i=1; i<=N+1; i++){
            dp[i] = Math.max(max, dp[i]);
            dp[T[i]+i] = Math.max(dp[T[i]+i], P[i]+dp[i]);
            max = Math.max(dp[i], max);
        }
        System.out.println(max);
    }
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
