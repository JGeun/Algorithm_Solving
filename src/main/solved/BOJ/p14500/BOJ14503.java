import java.io.*;
import java.util.*;

/**
 * 이 문제는 N*M크기의 map으로 이루어져 있고 북쪽: 0, 동쪽: 1, 남쪽: 2, 서쪽: 3으로 정해져있습니다.
 * 바라보는 방향을 기준으로 왼쪽방향부터 차례대로 탐색하고 원래대로 돌아왔다면 (청소할 곳이 없다면)
 * 바라보는 방향을 유지하고 한 칸 뒤로 후진합니다. 청소한 공간이 존재한다면 2로 바꿔줍니다.
 * 저는 이걸 for 4 통해 각 방향별로 체크하고 없으면 후진하는 코드를 짤 겁니다.
 */
public class Main {

    private static int N, M, r, c, d; // N: 세로, M: 가로, r: x축 좌표, c: y축 좌표, d: 방향
    private static int[][] map; // 입력된 칸을 저장하는 map
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 0: 북쪽, 1: 동쪽, 2: 남쪽, 3: 서쪽

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int ans = 0;

        while(true) {
            if (map[r][c] == 0) ans += 1; // 현재 위치를 청소한다

            map[r][c] = 2;

            boolean isClean = false;
            int curD = d; // 현재 바라보는 방향
            for (int i=0; i<4; i++) {
                curD = getRobotDir(curD); // 왼쪽 방향으로 전환한 값
                int fr = r + dir[curD][0]; // 바라보는 방향의 칸 x 위치
                int fc = c + dir[curD][1]; // 바라보는 방향의 칸 y 위치

                if (map[fr][fc] == 0) {
                    r = fr; c = fc; d = curD;
                    isClean = true;
                    break;
                }
            }

            if (isClean) continue;

            int br = r - dir[d][0]; // 후진할 위치의 칸 x 위치
            int bc = c - dir[d][1]; // 후진할 위치의 칸 y 위치

            if (map[br][bc] == 1) break;

            r = br;
            c = bc;
        }

        System.out.println(ans);
    }

    private static int getRobotDir(int dir) {
        return dir - 1 < 0 ? 3 : dir -1;
    }

    private static void printMap() {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}