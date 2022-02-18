package BOJ.p1900;

import java.io.*;
import java.util.*;

public class BOJ1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static int[][] dp;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N+1][N+1];
        dp = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

    static int DFS(int x, int y){
        if(dp[x][y] != 0) return dp[x][y];

        dp[x][y] = 1;

        for(int i=0; i<4; i++){
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(fx>=1 && fy>=1 && fx<=N && fy<=N){
                if(map[x][y] < map[fx][fy]){
                    dp[x][y] = Math.max(dp[x][y], DFS(fx, fy)+1);
                }
            }
        }
        return dp[x][y];
    }

    static void process(){
        int ans = 0;
        for(int i=1; i<=N; i++){
            for(int j=1; j<=N; j++){
                ans = Math.max(ans, DFS(i, j));
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
