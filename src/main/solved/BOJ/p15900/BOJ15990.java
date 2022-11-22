import java.io.*;
import java.util.*;

/**
 * 1. 재귀로 접근 -> 시간초과
 * 2. 다이나믹 프로그래밍
 */

public class Main {

    private static long[][] dp = new long[100001][4];
    private final static int MOD = 1000000009;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[1][1] = 1; dp[2][2] = 1; dp[3][1] = 1; dp[3][2] = 1; dp[3][3] = 1;

        for (int i=4; i<=100000; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3])%MOD;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3])%MOD;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2])%MOD;
        }

        int T = Integer.parseInt(br.readLine());
        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            sb.append((dp[n][1] + dp[n][2] + dp[n][3])%MOD).append('\n');
        }

        System.out.print(sb.toString());
    }
}