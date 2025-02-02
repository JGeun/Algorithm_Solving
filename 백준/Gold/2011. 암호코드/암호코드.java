
import java.io.*;
import java.util.*;

/**
 * dfs로 풀기엔 완전탐색 5000개 하는 것이 말이 안됨.
 * dp로 O(n)으로 가져가야 함.
 */
class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static final int ALPHA = 26;
    private static String N;
    private static int nLen;
    private static int[] nums;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        if(N.equals("0")) {
            System.out.println(0);
            return;
        }

        // 예를 들어 25인 경우 (02)5 - BE 와 (0)25 - Y인 경우가 있음.
        // 따라서 두번 째 자리에서 1~26까지 확인할 때 K~Z까지는 1이 더해져야 하므로 dp[0]에 1을 넣어줌
        dp[0] = 1;
        for (int i=1; i<=nLen; i++) {
            if (nums[i] >= 1 && nums[i] <= 9) {
                dp[i] = (dp[i] + dp[i-1]) % 1000000;
            }

            if (i == 1) continue;
            if (nums[i-1] == 0) continue;

            int first = nums[i-1]*10 + nums[i];

            // 이전 자리를 합쳐서 26을 넘어가면 알파벳으로 대응 불가능
            if (first >= 10 && first <= ALPHA) {
                dp[i] = (dp[i] + dp[i-2]) % 1000000;
            }

        }

        System.out.println(dp[nLen]);
    }

    private static void input() throws IOException {
        N = br.readLine();
        nLen = N.length();
        dp = new int[nLen+1];
        nums = new int[nLen+1];
        for (int i=0; i<nLen; i++) {
            nums[i+1] = N.charAt(i) - '0';
        }
    }
}
