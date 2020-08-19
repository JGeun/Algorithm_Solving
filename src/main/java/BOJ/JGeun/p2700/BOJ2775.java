package BOJ.JGeun.p2700;

import java.util.Scanner;

public class BOJ2775 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] dp = new int[15][15];
		for(int i=1; i<=14; i++)
			dp[0][i] = i;
		for(int i=1; i<=14; i++) {
			for(int j=1; j<=14; j++) {
				dp[i][j] = dp[i][j-1]+dp[i-1][j];
			}
		}
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++){
			int k =sc.nextInt();
			int n = sc.nextInt();
			System.out.println(dp[k][n]);
		}
	}
}
