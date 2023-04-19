import java.io.*;
import java.util.*;

// 이 문제는 다익스트라로 연결된 그래프 중 가장 단거리만 골라서 돌아오는 형식입니다.
class Main {

    private static int N, M, X;
    private static ArrayList<ArrayList<Node>> adj;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int answer = 0;
        for (int i=1; i<=N; i++) {
            int res = findRoute(i, X) + findRoute(X, i);
            answer = Math.max(answer, res);
        }

        System.out.println(answer);
    }

    private static int findRoute(int start, int end) {
        int[] dist = new int[N+1];
        boolean[] visited = new boolean[N+1];

        Arrays.fill(dist, 10000001);
        dist[start] = 0;

        for (int i=0; i<N; i++) {
            int nodeValue = Integer.MAX_VALUE;
            int nodeIdx = 0;
            for (int j=1; j<=N; j++) {
                if (!visited[j] && dist[j] < nodeValue) {
                    nodeValue = dist[j];
                    nodeIdx = j;
                }
            }

            visited[nodeIdx] = true;

            for (Node node : adj.get(nodeIdx)) {
                if (dist[node.idx] > dist[nodeIdx] + node.time) {
                    dist[node.idx] = dist[nodeIdx] + node.time;
                }
            }
        }

        return dist[end];
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            adj.get(a).add(new Node(b, c));
        }
    }

    static class Node {
        int idx, time;

        public Node(int idx, int time) {
            this.idx = idx; this.time = time;
        }
    }
}