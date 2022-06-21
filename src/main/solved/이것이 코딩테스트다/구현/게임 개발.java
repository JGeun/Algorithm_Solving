import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, A, B, d;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        input();
        int ans = process(A, B, d) + 1; //현재 위치
        System.out.println(ans);
    }

    private static int process(int x, int y, int d) {
        //현재 방향을 기준으로 왼쪽 방향(반시계 방향 90도 회전한 방향)
        visited[x][y] = true;
        int start = d;

        do {
            start = start - 1 < 0 ? 3 : start - 1;

            int fx = x + dir[start][0];
            int fy = y + dir[start][1];

            if (validation(fx, fy)) continue;

            return process(fx, fy, start) + 1;

        } while (d != start);

        int fx = x - dir[start][0];
        int fy = y - dir[start][1];

        if(validation(fx, fy)) return 0;
        return process(fx, fy, d) + 1;
    }

    private static boolean validation(int fx, int fy) {
        return fx < 0 || fy < 0 || fx >= N || fy >= M || visited[fx][fy] || map[fx][fy] == 1;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}