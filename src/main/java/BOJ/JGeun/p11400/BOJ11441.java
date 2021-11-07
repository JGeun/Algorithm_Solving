package BOJ.JGeun.p11400;

import java.io.*;
import java.util.*;

public class BOJ11441 {
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
            dp[i] = dp[i-1] + Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
    }

    static void process() throws IOException{
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            sb.append(dp[y]-dp[x-1]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
