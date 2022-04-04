package BOJ.p20100;

import java.io.*;
import java.util.*;

public class BOJ20168 {
    private static int N, M, A, B, C, ans = -1;
    private static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            nodes.add(new ArrayList<>());

        for(int i=1; i<=M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Node(b, c));
            nodes.get(b).add(new Node(a, c));
        }

        findRoute(A, B, 0, -1, new boolean[N+1]);
        System.out.println(ans);
    }

    private static void findRoute(int start, int end, int sum, int maxWeight, boolean[] visited){
        if(start == end){
            if(ans == -1) ans = maxWeight;
            else ans = Math.min(maxWeight, ans);
            return;
        }

        visited[start] = true;
        for(Node n : nodes.get(start)){
            if(sum+n.weight <= C && !visited[n.to]){
                visited[n.to] = true;
                findRoute(n.to, end, sum+n.weight, Math.max(maxWeight, n.weight), visited);
                visited[n.to] = false;
            }
        }
    }

    static class Node{
        int to, weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }
}
