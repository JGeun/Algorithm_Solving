package BOJ.JGeun.p11000;

import java.util.Scanner;

public class BOJ11057 {
	public static void main(String[] args){ 
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] dp = new int[N+1][10];
		for(int i=0; i<10; i++)
			dp[1][i] = 1;
		
		for(int i=2; i<=N; i++) {
			int sum = 0;
			for(int j=0; j<10; j++)
				sum += dp[i-1][j];
			
			dp[i][0] = sum%10007;
			for(int j=1; j<10; j++) {
				sum -= dp[i-1][j-1];
				dp[i][j] = sum %10007;
			}
		}
		
		int sumT = 0;
		for(int i=0; i<10; i++)
			sumT += dp[N][i];
		System.out.println(sumT % 10007);
	}
}	
