package BOJ.p20100;

import java.io.*;
import java.util.*;

public class BOJ20182 {
    private static int N, M, A, B, C;
    private static final int INF = 5000001;
    private static ArrayList<ArrayList<Node>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    private static void process() {
        int start = 1, end = 20, ans = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (dijk(A, B, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }

    private static boolean dijk(int start, int end, int maxCost) {
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);

        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            for (Node next : adj.get(node.n)) {
                if (dist[node.n] + next.cost > C || maxCost < next.cost || node.n == next.n) continue;
                if (dist[next.n] > dist[node.n] + next.cost) {
                    dist[next.n] = dist[node.n] + next.cost;
                    pq.add(new Node(next.n, node.cost + next.cost));
                }
            }
        }
        return dist[end] != INF;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= N; i++) adj.add(new ArrayList<>());

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            adj.get(a).add(new Node(b, c));
            adj.get(b).add(new Node(a, c));
        }
    }

    private static class Node {
        int n, cost;

        public Node(int n, int cost) {
            this.n = n;
            this.cost = cost;
        }
    }
}
