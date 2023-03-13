import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;
    private static PriorityQueue<Point> pq = new PriorityQueue<Point>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int answer = 0;
        pq.add(new Point(1, 1, 0));

        while(!pq.isEmpty()) {
            Point cur = pq.poll();

            if (cur.x == N && cur.y == M) {
                answer = cur.cnt;
                break;
            }

            for (int i=0; i<4; i++) {
                int fx = cur.x + dx[i];
                int fy = cur.y + dy[i];

                if (fx <= 0 || fy <= 0 || fx > N || fy > M) continue;
                if (visited[fx][fy]) continue;

                visited[fx][fy] = true;
                pq.add(new Point(fx, fy, map[fx][fy] == 1 ? cur.cnt+1 : cur.cnt));
            }
        }

        System.out.println(answer);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for (int i=1; i<=N; i++) {
            String line = br.readLine();

            for (int j=1; j<=M; j++) {
                map[i][j] = line.charAt(j-1)-'0';
            }
        }

    }

    private static class Point implements Comparable<Point>{
        private int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Point p) {
            return this.cnt - p.cnt;
        }
    }
}