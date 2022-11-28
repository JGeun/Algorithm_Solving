import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
    private static int n, m, cnt;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    cnt = 1;
                    visited[i][j] = true;
                    checkMap(i, j);
                    pq.add(cnt);
                }
            }
        }

        System.out.println(pq.size() + "\n" + (pq.size() == 0 ? 0 : pq.poll()));
    }

    private static void checkMap(int x, int y) {

        for (int i=0; i<4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx >=0 && fy >=0 && fx < n && fy < m && map[fx][fy] == 1 && !visited[fx][fy]) {
                visited[fx][fy] = true;
                cnt += 1;
                checkMap(fx, fy);
            }
        }
    }
}