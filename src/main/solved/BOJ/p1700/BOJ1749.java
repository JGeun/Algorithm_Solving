import java.io.*;
import java.util.*;

// 각 배열별로 누적합을 저장한다
// 그 영역의 합은 dp[N][M] - dp[N-1][M] - dp[N][M-1] + dp[N-1][M-1]
class Main {

    private static int N, M;
    private static int[][] map, dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int ans = -10001;
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                for (int h=0; h<i; h++) {
                    for (int w=0; w<j; w++) {
                        int result = dp[i][j] - dp[h][j] - dp[i][w] + dp[h][w];
                        ans = Math.max(ans, result);
                    }
                }
            }
        }
        System.out.println(ans);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        dp = new int[N+1][M+1];

        for(int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }
    }
}