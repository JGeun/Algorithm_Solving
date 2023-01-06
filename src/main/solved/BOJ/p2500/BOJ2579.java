import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] stairs;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int i=2; i<=N; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
            dp[i][1] = dp[i-1][0] + stairs[i];
        }
        System.out.println(Math.max(dp[N][0], dp[N][1]));
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        stairs = new int[N+1];
        for (int i=1; i<=N; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        dp = new int[N+1][2];
        dp[1][0] = stairs[1];
    }
}