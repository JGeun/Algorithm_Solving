import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] parent;
    private static PriorityQueue<Edge> edgePQ = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int ans = 0;
        int house = 0;

        while(!edgePQ.isEmpty()) {
            Edge edge = edgePQ.poll();

            if (find(edge.start) != find(edge.end)) {
                union(edge.start, edge.end);
                house += 1;
                if (house != N-1) {
                    ans += edge.weight;
                }
            }
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N+1];
        for (int i=1; i<=N; i++) {
            parent[i] = i;
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            edgePQ.add(new Edge(S, E, W));
        }
    }

    private static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[y] = x;
        }
    }

    static class Edge implements Comparable<Edge>{
        private int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge e) {
            return this.weight - e.weight;
        }
    }
}