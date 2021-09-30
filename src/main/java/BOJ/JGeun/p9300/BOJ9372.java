package BOJ.JGeun.p9300;

import java.io.*;
import java.util.*;

public class BOJ9372 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M, ans;
    static boolean[] visit;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adj = new ArrayList[N+1];
        visit = new boolean[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void dfs(int start){
        visit[start] = true;

        for(int node : adj[start]){
            if(!visit[node]){
                ans+=1;
                dfs(node);
            }
        }
    }
    static void process(){
        ans = 0;
        for(int i=1; i<=N; i++){
            if(!visit[i]) dfs(i);
        }

        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            input();
            process();
        }
        System.out.print(sb);
    }
}
