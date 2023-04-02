import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[][] matrix, dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {

        for (int k = 1; k <= N; k++) {
            for (int from = 1; from + k <= N; from++) {
                int to = from + k;
                dp[from][to] = Integer.MAX_VALUE;

                for (int divide = from; divide < to; divide++) {
                    dp[from][to] = Math.min(dp[from][to], dp[from][divide] + dp[divide + 1][to] + matrix[from][0] * matrix[divide][1] * matrix[to][1]);
                }
            }
        }

        System.out.println(dp[1][N]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        matrix = new int[N + 1][2];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}