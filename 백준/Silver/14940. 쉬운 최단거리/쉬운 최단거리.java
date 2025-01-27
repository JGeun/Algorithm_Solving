
import java.io.*;
import java.util.*;

/**
 * bfs로 최단 길이를 가져가는 것.
 * 노드: n*m => 1,000,000
 * 간선: n*m*4
 * 시간 복잡도: O(n^2)
 */
class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static int n, m;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static int[][] paths;
    private static int startX, startY;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        Queue<Integer> que = new LinkedList<>();

        que.add(startX);
        que.add(startY);
        paths[startX][startY] = 0;

        while (!que.isEmpty()) {
            int x = que.poll();
            int y = que.poll();

            for (int i=0; i<4; i++) {
                int fx = x + dx[i];
                int fy = y + dy[i];

                // map의 범위를 벗어나는 좌표
                if (fx < 0 || fx >= n || fy < 0 || fy >= m) continue;
                // 도달할 수 없는 위치
                if (map[fx][fy] == 0) continue;
                // 도달할 수 있으나 이미 지나간 땅
                if (paths[fx][fy] != -1) continue;

                paths[fx][fy] = paths[x][y] + 1;
                que.add(fx);
                que.add(fy);
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                sb.append(paths[i][j]);

                if (j != m-1) {
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void input() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        paths = new int[n][m];
        for (int i= 0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] != 0) {
                    paths[i][j] = -1;
                }
                if (map[i][j] == 2) {
                    startX = i; startY = j;
                }
            }
        }
    }
}
