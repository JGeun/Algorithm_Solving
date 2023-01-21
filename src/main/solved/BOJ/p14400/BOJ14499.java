import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, x, y, k;
    private static int[] dice; // 0: 윗면, 1:북, 2:동, 3:서, 4:남, 5: 바닥면
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[][] map;
    private static int[] order;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<Integer> ansList = new ArrayList<>();

        for (int i=0; i<k; i++) {
            int fx = x + dx[order[i]-1];
            int fy = y + dy[order[i]-1];

            if (fx < 0 || fy < 0 || fx >= N || fy >= M) continue;

            // 주사위 굴리기
            rollDice(order[i]);

            // 상단에 쓰여 있는 값 저장
            ansList.add(dice[0]);

            if (map[fx][fy] == 0) {
                map[fx][fy] = dice[5];
            } else {
                dice[5] = map[fx][fy];
                map[fx][fy] = 0;
            }
            x = fx; y = fy;
        }

        ansList.forEach(System.out::println);
    }

    private static void rollDice(int dir) {
        if (dir == 1) {
            rollWest();
        } else if (dir == 2) {
            rollEast();
        } else if (dir == 3) {
            rollNorth();
        } else {
            rollSouth();
        }
    }

    private static void rollWest() {
        int[] temp = getTempDice();

        dice[0] = temp[2]; // 동쪽 -> 윗면
        dice[2] = temp[5]; // 서쪽 -> 바닥
        dice[3] = temp[0]; // 윗면 -> 서쪽
        dice[5] = temp[3]; // 바닥 -> 동쪽
    }

    private static void rollEast() {
        int[] temp = getTempDice();

        dice[0] = temp[3]; // 서쪽 -> 윗면
        dice[2] = temp[0]; // 윗면 -> 동쪽
        dice[3] = temp[5]; // 바닥 -> 서쪽
        dice[5] = temp[2]; // 동쪽 -> 바닥
    }

    private static void rollNorth() {
        int[] temp = getTempDice();

        dice[0] = temp[4]; // 남쪽 -> 윗면
        dice[1] = temp[0]; // 윗면 -> 북쪽
        dice[4] = temp[5]; // 바닥 -> 남쪽
        dice[5] = temp[1]; // 북쪽 -> 바닥

    }

    private static void rollSouth() {
        int[] temp = getTempDice();

        dice[4] = temp[0]; // 윗면 -> 남쪽
        dice[5] = temp[4]; // 남쪽 -> 바닥
        dice[0] = temp[1]; // 북쪽 -> 윗면
        dice[1] = temp[5]; // 바닥 -> 북쪽
    }

    private static int[] getTempDice() {
        int[] temp = new int[6];
        for (int i = 0; i < 6; i++) {
            temp[i] = dice[i];
        }
        return temp;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        dice = new int[6];

        map = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order = new int[k];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<k; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }
    }
}

/*
 *  0 2
 *  3 4
 *  5 6
 *  7 8
 */