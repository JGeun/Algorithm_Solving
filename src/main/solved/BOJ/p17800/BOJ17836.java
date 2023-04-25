import java.io.*;
import java.util.*;

// 이 문제는 두 가지로 나눌 수 있습니다.
// 1. 그람을 찾지 않고 일정 시간 내로 들어가는 케이스
// 2. 그람을 찾고 그람의 위치 - 공주 위치로 계산하는 케이스
class Main {

    private static int N, M, T;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[] gram = new int[2];
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        int ans = Integer.MAX_VALUE;
        int res = findRoute(N, M);
        if (res != -1 && res <= T) {
            ans = Math.min(ans, res);
        }

        res = findRoute(gram[0], gram[1]);
        if (res != -1) {
            int totalRes = res + N - gram[0] + M - gram[1];
            if (totalRes <= T) {
                ans = Math.min(ans, res + N - gram[0] + M - gram[1]);
            }
        }

        System.out.println(ans == Integer.MAX_VALUE ? "Fail" : ans);
    }

    private static int findRoute(int endX, int endY) {
        boolean[][] visited = new boolean[N + 1][M + 1];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1, 1, 0});
        visited[1][1] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == endX && cur[1] == endY) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int fx = cur[0] + dx[i];
                int fy = cur[1] + dy[i];

                if (fx <= 0 || fy <= 0 || fx > N || fy > M || visited[fx][fy] || map[fx][fy] == 1) continue;
                visited[fx][fy] = true;
                q.offer(new int[]{fx, fy, cur[2] + 1});
            }
        }
        return -1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 2) continue;
                gram[0] = i;
                gram[1] = j;
            }
        }
    }

}