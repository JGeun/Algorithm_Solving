import java.io.*;
import java.util.*;

public class BOJ15684 {
    private static int N, M, H, ans;
    private static int[][] map;
    private static boolean isFinish = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 1][N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1; map[x][y + 1] = 2;
        }

        for (int i = 0; i <= 3; i++) {
            ans = i;
            dfs(1, 0);
            if(isFinish) break;
        }
        System.out.println(isFinish ? ans : -1);
    }

    private static void dfs(int height, int cnt) {
        if(isFinish) return;
        if(ans == cnt) {
            if(isInLine()) isFinish = true;
            return;
        }

        for (int i=height; i<H+1; i++) {
            for(int j=1; j<N; j++) {
                if(map[i][j] == 0 && map[i][j+1] == 0) {
                    map[i][j] = 1;
                    map[i][j+1] = 2;
                    dfs(i, cnt+1);
                    map[i][j] = map[i][j+1] = 0;
                }
            }
        }
    }

    private static boolean isInLine() {
        for(int i=1; i<=N; i++) {
            int height = 1, line = i;
            for (int j=0; j<H; j++) {
                if(map[height][line] == 1) line+=1;
                else if(map[height][line] == 2) line-=1;
                height += 1;
            }
            if(line != i) return false;
        }
        return true;
    }
}