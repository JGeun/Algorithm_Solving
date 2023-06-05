import java.io.*;
import java.util.*;

class Main {

    private static int N, ans = Integer.MAX_VALUE;
    private static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        dist = new int[N][N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                dist[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            findRoute(i, i, visited, 1, 0);
        }

        System.out.println(ans);
    }

    private static void findRoute(int start, int pos, boolean[] visited, int cnt, int sum) {
        if (cnt == N) {
            if (dist[pos][start] != 0) {
                ans = Math.min(ans, sum+dist[pos][start]);
            }
            return;
        }

        for (int i=0; i<N; i++) {
            if (visited[i] || dist[pos][i] == 0) continue;
            visited[i] = true;
            findRoute(start, i, visited, cnt+1, sum+dist[pos][i]);
            visited[i] = false;
        }
    }
}

