package BOJ.JGeun.p10000;

import java.io.*;
import java.util.*;

public class BOJ10026 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static char[][] picture;
    static boolean[][] visit;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        picture = new char[N + 1][N + 1];
        visit = new boolean[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            String line = br.readLine();
            for (int j = 1; j <= N; j++) {
                picture[i][j] = line.charAt(j - 1);
            }
        }
    }

    static void DFS(int x, int y, int c, char color) {
        visit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx >= 1 && fy >= 1 && fx <= N && fy <= N) {
                if (color == 'B'){
                    if (!visit[fx][fy] && picture[fx][fy] == color) DFS(fx, fy, c, color);
                } else{
                    if (c == 0){
                        if(picture[fx][fy] == color && !visit[fx][fy]) DFS(fx, fy, c, color);
                    }else {
                        if ((picture[fx][fy] == 'R' || picture[fx][fy] == 'G') && !visit[fx][fy])
                            DFS(fx, fy, c, color);
                    }
                }
            }
        }
    }

    static void process() {
        for (int c = 0; c < 2; c++) {
            int cnt = 0;
            for (boolean[] v : visit) Arrays.fill(v, false);
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (!visit[i][j]) {
                        cnt += 1;
                        DFS(i, j, c, picture[i][j]);
                    }
                }
            }
            sb.append(cnt);
            if (c == 0) sb.append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
