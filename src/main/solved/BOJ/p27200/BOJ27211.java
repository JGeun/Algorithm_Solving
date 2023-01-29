import java.io.*;
import java.util.*;

class Main {

    private static int N, M, point = 2;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (visited[i][j] || map[i][j] >= 1) continue;
                checkMap(i, j);
                point += 1;
            }
        }

        System.out.println(point-2);
    }

    private static void printMap() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------");
    }

    private static void checkMap(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        queue.offer(y);
        visited[x][y] = true;
        map[x][y] = point;

        while(!queue.isEmpty()) {
            int px = queue.poll();
            int py = queue.poll();

            for (int i=0; i<4; i++) {
                int fx = px + dx[i];
                int fy = py + dy[i];

                if (fx < 0) fx = N-1;
                if (fy < 0) fy = M-1;
                if (fx >= N) fx = 0;
                if (fy >= M) fy = 0;

                if (visited[fx][fy] || map[fx][fy] >= 1) continue;
                visited[fx][fy] = true;
                map[fx][fy] = point;
                queue.offer(fx);
                queue.offer(fy);
            }
        }
    }
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }

}