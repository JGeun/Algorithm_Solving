import java.io.*;
import java.util.*;

/*
 * 처음 접근법: 모든 케이스를 확인하며 0보다 작아지는 경우가 있는지를 찾으면 됩니다. 50%에서 시간초과 (34분 만에 해결)
 * 이 문제를 접근해야하는 해답: 벨만 포드 알고리즘
 *
 */
class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int N, M, W, INF = 987654321;
    private static int[] dist;
    private static ArrayList<ArrayList<Node>> nodes;

    public static void main(String[] args) throws IOException {

        int TC = Integer.parseInt(br.readLine());
        while (TC-- > 0) {
            init();
            process();
        }
        System.out.print(sb.toString());
    }

    private static void process() {
        boolean isFind = false;

        for (int i=1; i<=N; i++) {
            if (bellmanFord(i)) {
                isFind = true;
                break;
            }
        }

        sb.append(isFind ? "YES\n" : "NO\n");
    }

    private static boolean bellmanFord(int start) {
        dist[start] = 0;
        boolean update = false;

        // (정점의 개수 - 1)번 동안 최단거리 초기화 작업을 반복함.
        for (int i = 1; i < N; i++) {
            update = false;

            // 최단거리 초기화
            for (int j = 1; j <= N; j++) {
                for (Node node : nodes.get(j)) {
                    if (dist[j] != INF && dist[node.end] > dist[j] + node.time) {
                        dist[node.end] = dist[j] + node.time;
                        update = true;
                    }
                }
            }

            if (!update) {
                break;
            }
        }

        if (update) {
            for (int i = 1; i<= N; i++) {
                for (Node node : nodes.get(i)) {
                    if (dist[i] != INF && dist[node.end] > dist[i] + node.time) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static void init() throws IOException {
        String[] inputLine = br.readLine().split(" ");
        N = Integer.parseInt(inputLine[0]);
        M = Integer.parseInt(inputLine[1]);
        W = Integer.parseInt(inputLine[2]);

        nodes = new ArrayList<>();
        dist = new int[N+1];
        Arrays.fill(dist, INF);

        // 각 지점은 1부터 시작
        for (int i = 0; i <= N; i++) {
            nodes.add(new ArrayList<>());
        }

        for (int i = 0; i < M+W; i++) {
            String[] roadLine = br.readLine().split(" ");
            int S = Integer.parseInt(roadLine[0]);
            int E = Integer.parseInt(roadLine[1]);
            int T = Integer.parseInt(roadLine[2]);

            if (i < M) {
                nodes.get(S).add(new Node(E, T));
                nodes.get(E).add(new Node(S, T));
            } else {
                nodes.get(S).add(new Node(E, -T));
            }
        }

    }

    static class Node {
        private int end, time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }
    }
}