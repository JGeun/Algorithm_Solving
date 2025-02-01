
import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();

    private static int T;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException{
        dp[1] = 1; dp[2] = 2; dp[3] = 2;
        // 2+2, 3+3의 케이스 일 때 추가적으로 한개씩 더해줘야 함.
        dp[4] = 1; dp[6] =1;

        for (int i=4; i<=100000; i++) {
            int first = i-2 >= 0 ? dp[i-2] : 0;
            int second = i-4 >= 0 ? dp[i-4] : 0;
            int third = i-6 >= 0 ? dp[i-6] : 0;

            dp[i] = (int)(((long)dp[i] + first + second + third) % 1000000009);
        }

        while(T-->0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        System.out.print(sb);
    }

    private static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        dp = new int[100001];
    }
}
