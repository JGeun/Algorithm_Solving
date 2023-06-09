import java.util.*;
import java.io.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M;
    private static int[] arr;
    private static boolean[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(dp[S-1][E-1] ? 1 : 0).append('\n');
        }

        System.out.print(sb);
    }

    private static void input() throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new boolean[N][N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                if (row < column) break;

                if (row == column) dp[column][row] = true;
                else {
                    if (arr[column] == arr[row]) {
                        if (row - column == 1) dp[column][row] = true;
                        else {
                            if (dp[column+1][row-1]) dp[column][row] = true;
                        }
                    }
                }
            }
        }
    }
}
