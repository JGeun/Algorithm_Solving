package BOJ.JGeun.p1800;

import java.io.*;
import java.util.*;

public class BOJ1890 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] map;
    static long[][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N+1][N+1];
        dp[1][1] = 1;
    }

    static void process(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(i==N && j==N) continue;
                int dist = map[i][j];
                if(i+dist<=N) dp[i+dist][j] += dp[i][j];
                if(j+dist<=N) dp[i][j+dist] += dp[i][j];
            }
        }
        System.out.println(dp[N][N]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
