import java.io.*;
import java.util.*;

public class Main {
    private static int R, C, N, time = 1;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            String[] line = br.readLine().split("");
            Arrays.fill(map[i], -1);
            for (int j = 0; j < C; j++) {
                map[i][j] = line[j].equals("O") ? 0 : -1;
            }
        }

        while (time != N) {
            time += 1;
            installBomb();

            if(time == N) break;

            time += 1;
            bomb();
        }
        print();
    }

    private static void bomb() {
        List<int[]> bombs = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == time-3) bombs.add(new int[]{i, j});
            }
        }

        for(int i=0; i<bombs.size(); i++) {
            int[] pos = bombs.get(i);

            for(int j=0; j<4; j++) {
                int fx = dx[j] + pos[0];
                int fy = dy[j] + pos[1];

                if (fx >= 0 && fy >= 0 && fx < R && fy < C) {
                    map[fx][fy] = -1;
                }
            }
            map[pos[0]][pos[1]] = -1;
        }
    }

    private static void installBomb() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] == -1) map[i][j] = time;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(map[i][j] == -1 ? '.' : 'O');
            }
            System.out.println();
        }
    }
}