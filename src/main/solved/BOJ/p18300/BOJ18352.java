import java.io.*;
import java.util.*;

class Main {

    private static int N, M, K, X;
    private static int[] dist;
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        List<Integer> ansList = new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        q.offer(X);
        visited[X] = true;
        dist[X] = 0;

        while(!q.isEmpty()) {
            int idx = q.poll();

            for (int next : adj.get(idx)) {
                if (visited[next] || dist[next] != Integer.MAX_VALUE) continue;

                visited[next] = true;
                dist[next] = dist[idx]+1;
                q.offer(next);
            }
        }

        StringBuilder sb = new StringBuilder();

        boolean isFindCity = false;
        for (int i=1; i<=N; i++) {
            if (dist[i] == K) {
                sb.append(i).append('\n');
                isFindCity = true;
            }
        }

        if (!isFindCity) sb.append(-1).append('\n');

        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            adj.get(S).add(E);
        }
    }
}