import java.io.*;
import java.util.*;

/**
 * 이 문제의 접근은 현재 날짜 + P[i] - 1 의 위치에 얻을 수 있는 최대 수익을 저장하는 것이다.
 * 예외케이스는 i+P[i]-1이 N보다 커질 경우를 대비해서 N+50(T의 최대값)+1(1일부터 시작) 만큼 배열을 확장시켜야 한다.
 */
class Main {

    private static int N;
    private static int[] T, P, dp;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        int dpMax = 0;
        for (int i=1; i<=N; i++) {
            dp[i] = Math.max(dp[i], dpMax);
            dp[i+T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
            dpMax = Math.max(dpMax, dp[i]);
        }

        int max = dp[1];
        for (int i=2; i<=N+1; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        T = new int[N+1];
        P = new int[N+1];
        dp = new int[N+50+2];

        for (int i=1; i<=N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
    }
}