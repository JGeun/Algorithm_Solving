import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 100];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            if (dp[i] >= Integer.MAX_VALUE) continue;
            for (int j=1; j<=arr[i]; j++) {
                dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }

        System.out.println(dp[N-1] >= Integer.MAX_VALUE ? -1 : dp[N-1]);
    }

}

// [0, 1, 2, 2, 3, 4, 4, 4, 5]