package BOJ.JGeun.p11400;

import java.io.*;
import java.util.*;

public class BOJ11437 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] depth;
    static int[] parent;
    static ArrayList<Integer>[] adj;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        depth = new int[N+1];
        parent = new int[N+1];
        depth[1] = 1; parent[1] = -1;
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }
    }

    static void setDepthAndParent(int start){
        for(int node : adj[start]){
            if(depth[node] == 0){
                depth[node] = depth[start]+1;
                parent[node] = start;
                setDepthAndParent(node);
            }
        }
    }

    static void process(int n1, int n2){
        int depth1 = depth[n1], depth2 =depth[n2];
        while(depth1 > depth2){
            depth1-=1;
            n1 = parent[n1];
        }
        while(depth1 < depth2){
            depth2-=1;
            n2 = parent[n2];
        }

        while(n1 != n2){
            n1 = parent[n1];
            n2 = parent[n2];
        }
        sb.append(n1).append('\n');
    }

    public static void main(String[] args) throws IOException {
        input();
        int M = Integer.parseInt(br.readLine());
        setDepthAndParent(1);
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            process(n1, n2);
        }
        System.out.print(sb);
    }
}
