import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp = new int[30001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // 바텀업
        for (int i=2; i<=X; i++) {
            dp[i] = dp[i-1] + 1; //1이 최소

            if(i % 2 == 0)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            if(i % 5 == 0)
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
        }

        System.out.println(dp[X]);
    }
}