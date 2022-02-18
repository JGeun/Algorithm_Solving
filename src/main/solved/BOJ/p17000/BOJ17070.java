package BOJ.p17000;

import java.io.*;
import java.util.*;

public class BOJ17070 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] map;
    static int[][][] dp;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process() {
        dp[1][2][0] = 1;

        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                if(map[i][j] == 1) continue;

                dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                if(map[i-1][j] == 0 && map[i][j-1] == 0){
                    dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }
        System.out.println(dp[N][N][0] + dp[N][N][1] + dp[N][N][2]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
