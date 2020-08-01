package BOJ.JGeun.p11000;

import java.util.Scanner;

public class BOJ11052 {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] card = new int[n+1];
		for(int i=1; i<=n; i++)
			card[i] = sc.nextInt();
		
		int[] dp = new int[n+1];

		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) 
				dp[i] = Math.max(dp[i], dp[i-j]+card[j]);
		}
		System.out.println(dp[n]);
	}
}	
