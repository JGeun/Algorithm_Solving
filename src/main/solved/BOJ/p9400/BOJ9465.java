package BOJ.p9400;

import java.util.Scanner;

public class BOJ9465 {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			
			int[][] sticker = new int[2][n+1];
			
			for(int k=0; k<2; k++) 
				for(int j=1; j<=n; j++)
					sticker[k][j] = sc.nextInt();
			
			int[][] dp = new int[2][n+1];
			dp[0][1] = sticker[0][1];
			dp[1][1] = sticker[1][1];
			
			for(int j=2; j<=n; j++) {
				int max = Math.max(dp[0][j-2], dp[1][j-2]);
				dp[0][j] = Math.max(dp[1][j-1], max) + sticker[0][j];
				dp[1][j] = Math.max(dp[0][j-1], max) + sticker[1][j];
			}
			
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}	
	}
}
