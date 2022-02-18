package BOJ.p11700;

import java.io.*;
import java.util.*;

public class BOJ11722 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] A, dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N+1]; dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) A[i] = Integer.parseInt(st.nextToken());
    }

    static void process(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<i; j++){
                if(A[i] < A[j]) dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i] += 1;
        }

        int max = 0;
        for(int i=1; i<=N; i++) max = Math.max(max, dp[i]);
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
