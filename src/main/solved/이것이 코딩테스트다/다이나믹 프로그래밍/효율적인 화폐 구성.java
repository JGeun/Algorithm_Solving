import java.io.*;
import java.util.*;

public class Main {
    private static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++) {
            int money = Integer.parseInt(br.readLine());
            for(int j=1; ; j++) {
                if(money*j > M) break;
                dp[money*j] = Math.min(dp[money*j], dp[money*(j-1)]+1);
            }
        }

        System.out.println(dp[M] == Integer.MAX_VALUE ? -1 : dp[M]);

    }
}