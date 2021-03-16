package BOJ.JGeun.p12800;

import java.util.Scanner;

public class BOJ12865 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] W = new int[N+1];
        int[] V = new int[N+1];
        int[] dp = new int[K+1];

        for(int i=1; i<=N; i++){
            W[i] = sc.nextInt();
            V[i] = sc.nextInt();
        }

        for(int i=1; i<=N; i++){
            for(int j=K; j-W[i] >= 0; j--){
                dp[j] = Math.max(dp[j], dp[j-W[i]] + V[i]);
            }
        }
        System.out.println(dp[K]);
    }
}
