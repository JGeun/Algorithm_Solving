import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        PriorityQueue<Node> pq = new PriorityQueue<>();

        long result = 0;
        int count = 0;
        pq.add(new Node(0, 0));

        while(!pq.isEmpty() && count < N) {
            Node curNode = pq.poll();

            if (visited[curNode.idx]) continue;
            visited[curNode.idx] = true;
            result += curNode.dist;

            for (Node next : adj.get(curNode.idx)) {
                if (visited[next.idx]) continue;

                pq.add(next);
            }

            count += 1;
        }

        System.out.println(result);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N];
        for (int i=0; i<N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                int dist = Integer.parseInt(st.nextToken());
                adj.get(i).add(new Node(j, dist));
            }
        }
    }

    static class Node implements Comparable<Node> {

        int idx, dist;

        public Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node e) {
            return this.dist - e.dist;
        }
    }
}
