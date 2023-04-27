import java.io.*;
import java.util.*;

// 0~19 를 이중반복문으로 돌면서 해당 위치에서 오른쪽, 아래, 대각선, 역대각선을 체크합니다
// 만약 존재하지 않으면 마지막에 0을 출력합니다.
class Main {

    private static int len = 19;
    private static int[][] map = new int[len][len];

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        checkOmok();

    }

    private static void checkOmok() {
        for (int i=0; i<len; i++) {
            for (int j=0; j<len; j++) {
                if (map[i][j] == 0) continue;
                if(isWin(i, j)) {
                    System.out.println(map[i][j]);
                    System.out.println((i+1) + " " + (j+1));
                    return ;
                }
            }
        }

        System.out.println(0);
    }

    private static boolean isWin(int x, int y) {
        // 오른쪽 체크
        if (y+4 < len && isLineSame(x, y, 0, 1)) {
            return true;
        }

        // 아래 체크
        if (x+4 < len && isLineSame(x, y, 1, 0)) {
            return true;
        }

        // 오른쪽 아래 대각선 체크
        if (x+4 < len && y+4 < len && isLineSame(x, y, 1, 1)) {
            return true;
        }

        // 오른쪽 위 대각선 체크
        if (x-4 >= 0 && y+4 < len && isLineSame(x, y, -1, 1)) {
            return true;
        }

        return false;
    }

    private static boolean isLineSame(int x ,int y, int dx, int dy) {
        int i = 1;
        while (i < 5) {
            if (map[x][y] != map[x+dx*i][y+dy*i]) {
                return false;
            }
            i += 1;
        }

        // 6목인 경우
        if (x-dx >= 0 && x-dx < len
                && y-dy >= 0 && y-dy < len
                && map[x][y] == map[x-dx][y-dy]
        ) return false;

        if (x+dx*i >= 0 && x+dx*i < len
                && y+dy*i >= 0 && y+dy*i < len
                && map[x][y] == map[x+dx*i][y+dy*i]
        ) return false;

        return true;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<len; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<len; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}