import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] indeg, prefixSum;
    private static int[] usedItems;
    private static ArrayList<Node>[] adj;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Deque<Integer> queue = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            if (indeg[i] == 0) {
                queue.add(i);
                prefixSum[i] = 1;
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (Node child : adj[x]) {
                int y = child.dist;
                indeg[y]--;
                if (indeg[y] == 0) queue.add(y);
                prefixSum[y] += child.weight * prefixSum[x];
            }
        }

        for (int i=1; i<=N; i++) {
            if (usedItems[i] == 0) {
                sb.append(i).append(" ").append(prefixSum[i]).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        usedItems = new int[N+1];
        indeg = new int[N+1];
        prefixSum = new int[N+1];
        adj = new ArrayList[N+1];
        for (int i=0; i<=N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            adj[X].add(new Node(Y, K));
            usedItems[X]++;
            indeg[Y]++;
        }
    }

    static class Node {
        int dist;
        int weight;

        public Node(int dist, int weight) {
            this.dist = dist;
            this.weight = weight;
        }
    }
}
