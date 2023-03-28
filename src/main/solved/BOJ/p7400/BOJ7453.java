import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[][] arr;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        int left = 0, right = N*N-1;
        long ans = 0;

        while (left < N*N && right >= 0) {
            if (dp[0][left] + dp[1][right] < 0) {
                left++;
            } else if (dp[0][left] + dp[1][right] > 0) {
                right--;
            } else {
                int leftCount = 1, rightCount = 1;
                while (left + 1 < N*N && (dp[0][left] == dp[0][left+1])) {
                    leftCount++;
                    left++;
                }
                while (right > 0 && (dp[1][right] == dp[1][right-1])) {
                    rightCount++;
                    right--;
                }
                ans += (long)leftCount * rightCount;
                left++;
            }
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N][4];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp = new int[2][N*N];
        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                dp[0][i*N+j] = arr[i][0] + arr[j][1];
                dp[1][i*N+j] = arr[i][2] + arr[j][3];
            }
        }

        Arrays.sort(dp[0]);
        Arrays.sort(dp[1]);
    }
}