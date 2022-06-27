import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 3;
        for(int i=3; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2]*2;
        }
        System.out.println(dp[N]);
    }
}