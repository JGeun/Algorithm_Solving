import java.io.*;
import java.util.*;

class Main {

    private static int N, M, R;
    private static int[][] arr;

    // 왼쪽, 아래, 오른쪽, 위
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[][] res = new int[N][M];

        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int minX = Math.min(i, N-i-1);
                int maxX = Math.max(i, N-i-1);
                int minY = Math.min(j, M-j-1);
                int maxY = Math.max(j, M-j-1);
                int line = Math.min(minX, minY);

                int[] pos = getPos(i, j, line);
                res[pos[0]][pos[1]] = arr[i][j];
            }
        }

        printArr(res);
    }

    private static void printArr(int[][] map) {
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] getPos(int x, int y, int line) {
        int minX = Math.min(line, N-line-1);
        int minY = Math.min(line, M-line-1);
        int maxX = Math.max(line, N-line-1);
        int maxY = Math.max(line, M-line-1);

        // 왼쪽, 아래, 오른쪽, 위
        int rotateCnt = R;
        while(rotateCnt-->0) {
            int dir = getDir(x, y, minX, maxX, minY, maxY);
            x += dx[dir];
            y += dy[dir];
        }

        return new int[]{x, y};
    }

    private static int getDir(int x, int y, int minX, int maxX, int minY, int maxY) {
        if (x == minX && y != minY) {
            return 0;
        } else if (y == minY && x != maxX) {
            return 1;
        } else if (x == maxX && y != maxY) {
            return 2;
        } else {
            return 3;
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}

