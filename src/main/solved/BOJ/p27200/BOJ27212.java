import java.io.*;
import java.util.*;

class Main {

    private static int N, M, C;
    private static int[] A, B;
    private static long[][] W, dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        for (int i=1; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1]+W[A[i]][B[j]], Math.max(dp[i-1][j], dp[i][j-1]));
            }
        }

        System.out.println(dp[N][M]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        dp = new long[N+1][M+1];
        W = new long[C+1][C+1];
        for (int i=1; i<=C; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=1; j<=C; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        B = new int[M+1];
        st = new StringTokenizer(br.readLine());
        for (int j=1; j<=M; j++) {
            B[j] = Integer.parseInt(st.nextToken());
        }
    }

}