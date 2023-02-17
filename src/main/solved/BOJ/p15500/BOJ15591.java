import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

    private static int N, Q;
    private static ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            adj.get(p).add(new int[]{q, r});
            adj.get(q).add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            boolean[] visited = new boolean[N + 1];
            visited[v] = true;
            Queue<Integer> que = new LinkedList<>();
            que.add(v);

            int ans = 0;
            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int[] a : adj.get(cur)) {
                    if (!visited[a[0]] && a[1] >= k) {
                        que.add(a[0]);
                        visited[a[0]] = true;
                        ans++;
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.print(sb.toString());

    }
}