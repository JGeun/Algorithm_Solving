package BOJ.p1500;

import java.io.*;
import java.util.*;

public class BOJ1520 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int M, N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); N = Integer.parseInt(st.nextToken());
        map = new int[M+1][N+1];
        dp = new int[M+1][N+1];
        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
    }

    static int process(int x, int y){
        if(x == M && y == N) return 1;
        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for(int i=0; i<4; i++){
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(fx>=1 && fy>=1 && fx<=M && fy<=N){
                if(map[fx][fy] < map[x][y]){
                    dp[x][y] += process(fx, fy);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(process(1, 1));
    }
}
