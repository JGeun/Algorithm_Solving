import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    private static int V, E;
    private static int[] parent;
    private static ArrayList<Edge> edgeList;

    public static void main(String[] args) throws IOException {

        input();
        solve();
    }

    private static void solve() {

        int sum = 0;
        for (Edge edge : edgeList) {
            if (!isSameParent(edge.v1, edge.v2)) {
                sum += edge.cost;
                union(edge.v1, edge.v2);
            }
        }
        System.out.println(sum);
    }

    private static int find(int n) {
        if (parent[n] == n) {
            return n;
        }
        return parent[n] = find(parent[n]);
    }

    private static void union(int x, int y) {
        x = find(x);
        y= find(y);

        if (x != y)
            parent[y] = x;
    }

    private static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        return x == y;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parent = new int[V+1];
        for (int i=1; i<=V; i++) {
            parent[i] = i;
        }

        edgeList = new ArrayList<>();
        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a, b, cost));
        }

        Collections.sort(edgeList);
    }

    private static class Edge implements Comparable<Edge>{
        private int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1; this.v2 = v2; this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}