import java.io.*;
import java.util.*;

public class Main {

    private static int H, W;
    private static int[][] map;
    private static int[] dx = {-1 ,1 ,0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        int time = 0;

        while(true) {
            int[][] temp = makeClone();
            checkAirPos(temp, 0, 0, new boolean[H][W]);
            checkBoundaryCheese(temp);
            int rest = meltCheese(temp);
            if (rest == 0) {
                sb.append(time+1).append('\n');
                break;
            }
            time += 1;
        }
        System.out.print(sb.toString());
    }

    private static int meltCheese(int[][] temp) {
        int cnt = 0;
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (temp[i][j] == 0 || temp[i][j] == -1 || temp[i][j] >= 3) map[i][j] = 0;
                else {
                    map[i][j] = 1;
                    cnt += 1;
                }
            }
        }
        return cnt;
    }

    private static void checkBoundaryCheese(int[][] temp) {
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                if (temp[i][j] != -1) continue;

                for(int k=0; k<4; k++) {
                    int fx = i + dx[k];
                    int fy = j + dy[k];

                    if (fx < 0 || fx >= H || fy < 0 || fy >= W) continue;
                    if (temp[fx][fy] == 0 || temp[fx][fy] == -1) continue;

                    if(temp[fx][fy] >= 1) {
                        temp[fx][fy] += 1;
                    }
                }
            }
        }
    }

    private static void checkAirPos(int[][] temp, int x, int y, boolean[][] visited) {
        temp[x][y] = -1;
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx < 0 || fx >= H || fy < 0 || fy >= W) continue;
            if (map[fx][fy] == 1) continue;
            if (visited[fx][fy]) continue;
            checkAirPos(temp, fx, fy, visited);
        }
    }

    private static void print(int[][] block) {
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------");
    }
    private static int[][] makeClone() {
        int[][] temp = new int[H][W];
        for (int i=0; i<H; i++) {
            for (int j=0; j<W; j++) {
                temp[i][j] = map[i][j];
            }
        }
        return temp;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        map = new int[H][W];

        for (int i=0; i<H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}