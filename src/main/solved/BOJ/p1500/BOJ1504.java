package BOJ.p1500;

import java.io.*;
import java.util.*;

public class BOJ1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, E, v1, v2, max = 200000000;
    static ArrayList<Node>[] adj;
    static int[] dist;
    static boolean[] check;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        check = new boolean[N+1];
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adj[x].add(new Node(y, r));
            adj[y].add(new Node(x, r));
        }
        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());
    }


    static int dijkstra(int start, int end){
        Arrays.fill(dist, max);
        Arrays.fill(check, false);

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));
        dist[start] = 0;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(!check[node.idx]){
                check[node.idx] = true;
                for(Node to : adj[node.idx]){
                    if(!check[to.idx] && dist[to.idx] > dist[node.idx] + to.weight){
                        dist[to.idx] = dist[node.idx] + to.weight;
                        queue.add(new Node(to.idx, dist[to.idx]));
                    }
                }
            }
        }
        return dist[end];
    }

    static void process(){

        int result1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        int result2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        if(result1 >= max && result2 >= max) sb.append(-1);
        else sb.append(Math.min(result1, result2));
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Node implements Comparable<Node>{
        int idx, weight;

        Node(int _to, int _weight){
            this.idx = _to; this.weight = _weight;
        }

        @Override
        public int compareTo(Node n){
            return this.weight - n.weight;
        }
    }
}
