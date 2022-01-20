package BOJ.p17600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17626 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] dp;

    static void input() throws IOException {
        n = Integer.parseInt(br.readLine());
        dp = new int[n+1];
        dp[0] = 0;
    }

    static void process(){

        for(int i=1; i<=n; i++){
            dp[i] = 4;
            int j = (int)Math.sqrt(i);
            while(j != 0){
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
                j-=1;
            }
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
