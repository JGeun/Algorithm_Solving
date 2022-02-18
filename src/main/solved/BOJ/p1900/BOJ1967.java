package BOJ.p1900;

import java.io.*;
import java.util.*;

public class BOJ1967 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, find=0;
    static int max = 0;
    static ArrayList<Node>[] adj;
    static boolean[] visit;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=0; i<=N; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            adj[x].add(new Node(y, dist));
            adj[y].add(new Node(x, dist));
        }
    }

    static void dfs(int start, int len){
        if(len > max){
            max = len;
            find = start;
        }

        for(Node n : adj[start]){
            if(!visit[n.idx]){
                visit[n.idx] = true;
                dfs(n.idx, n.len +len);
            }
        }
    }

    static void process() {
        visit = new boolean[N+1];
        visit[1] = true;
        dfs(1, 0);

        visit = new boolean[N+1];
        visit[find] = true;
        dfs(find, 0);

        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Node {
        int idx, len;
        Node(int _idx, int _length){
            this.idx = _idx; this.len = _length;
        }
    }
}
