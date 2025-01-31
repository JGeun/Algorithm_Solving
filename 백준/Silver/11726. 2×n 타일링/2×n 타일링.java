
import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int n;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        for (int i=3; i<=n; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);
    }

    private static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[1005];
        dp[1] = 1;
        dp[2] = 2;
    }
}