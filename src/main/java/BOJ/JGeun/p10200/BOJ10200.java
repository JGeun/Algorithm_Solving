package BOJ.JGeun.p10200;

import java.io.*;
import java.util.*;

public class BOJ10200 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            dp[i] = dp[i-1]+Integer.parseInt(st.nextToken());
    }

    static void process(){
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
            for(int j=1; j<=i; j++)
                ans = Math.max(ans, dp[i]-dp[j-1]);
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException{
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            input();
            process();
        }
        System.out.print(sb);
    }
}
