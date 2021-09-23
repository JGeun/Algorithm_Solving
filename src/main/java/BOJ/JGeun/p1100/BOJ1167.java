package BOJ.JGeun.p1100;

import java.io.*;
import java.util.*;

public class BOJ1167 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, find;
    static int max = 0;
    static ArrayList<Node>[] adj;
    static boolean[] visit;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true) {
                int idx = Integer.parseInt(st.nextToken());
                if (idx == -1) break;
                int len = Integer.parseInt(st.nextToken());
                adj[s].add(new Node(idx, len));
            }
        }
    }

    static void dfs(int start, int len){
        if(len > max){
            max = len;
            find = start;
        }
        visit[start] = true;

        for(Node n : adj[start]){
            if(!visit[n.idx]){
                dfs(n.idx, n.len +len);
                visit[n.idx] = true;
            }
        }
    }

    static void process() {
        visit = new boolean[N+1];
        dfs(1, 0);

        visit = new boolean[N+1];
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
