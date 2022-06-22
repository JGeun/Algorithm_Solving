import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] line = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    checkMap(i, j);
                    ans += 1;
                }
            }
        }
        System.out.println(ans);
    }

    private static void checkMap(int x, int y) {
        map[x][y] = 2;
        for(int i=0; i<4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(fx < 0 || fx >= N || fy < 0 || fy >= M || map[fx][fy] != 0) continue;

            checkMap(fx, fy);
        }
    }
}