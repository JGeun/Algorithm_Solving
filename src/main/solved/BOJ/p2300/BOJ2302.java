import java.io.*;
import java.util.*;

public class Main {

    private static int N, M, ans = 1;
    private static int[] dp = new int[41];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp[0] = 1; dp[1] = 1; dp[2] = 2;
        for (int i=3; i<=40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        int prev = 0;

        for (int i=0; i<M; i++) {
            int pos = Integer.parseInt(br.readLine());
            ans *= dp[pos-prev-1];
            prev = pos;
        }

        ans *= dp[N-prev];

        System.out.println(ans);
    }
}