package BOJ.p24500;

import java.io.*;
import java.util.*;

public class BOJ24513 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, M;
    private static int[][] map;
    private static int[][] visited;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                visited[i][j] = Integer.MAX_VALUE;
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1 || map[i][j] == 2) {
                    visited[i][j] = 1;
                    queue.add(new int[]{i, j, 1});
                }
            }
        }

        checkVirus(queue);
        calcVirusCnt();
    }

    private static void calcVirusCnt() {
        int ans1 = 0, ans2 = 0, ans3 = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) ans1 += 1;
                else if (map[i][j] == 2) ans2 += 1;
                else if (map[i][j] == 3) ans3 += 1;
            }
        }

        System.out.println(ans1 + " " + ans2 + " " + ans3);
    }

    private static void checkVirus(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] p = queue.poll();

            if(map[p[0]][p[1]] == 3) continue;

            for (int i = 0; i < 4; i++) {
                int fx = p[0] + dx[i];
                int fy = p[1] + dy[i];

                if (fx >= 0 && fx < N && fy >= 0 && fy < M) {
                    if(map[fx][fy] == -1 || map[fx][fy] == 3) continue;
                    if (visited[fx][fy] < p[2]+1) continue;
                    if(visited[fx][fy] == p[2]+1 && map[fx][fy] != map[p[0]][p[1]]) map[fx][fy] = 3;
                    if(visited[fx][fy] == Integer.MAX_VALUE){
                        map[fx][fy] = map[p[0]][p[1]];
                        visited[fx][fy] = p[2]+1;
                        queue.add(new int[]{fx,fy,p[2]+1});
                    }
                }
            }
        }
    }
}