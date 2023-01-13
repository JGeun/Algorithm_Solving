import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, R;
    private static ArrayList<ArrayList<Integer>> adj;
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve(R);
    }

    private static void solve(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        int order = 1;
        while(!queue.isEmpty()) {
            int pos = queue.poll();

            if (visited[pos] != 0) continue;
            visited[pos] = order++;

            for(int node : adj.get(pos)) {
                if (visited[node] != 0) continue;
                queue.offer(node);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i=1; i<=N; i++) {
            Collections.sort(adj.get(i));
        }
    }
}