package BOJ.JGeun.p2500;

import java.io.*;
import java.util.*;

public class BOJ2533 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] dp;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void process() throws IOException{
        dfs(1, -1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }

    static void dfs(int node, int parent){
        dp[node][0] = 0;
        dp[node][1] = 1;

        for(int next : adj[node]){
            if(next != parent){
                dfs(next, node);
                dp[node][0] += dp[next][1];
                dp[node][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
