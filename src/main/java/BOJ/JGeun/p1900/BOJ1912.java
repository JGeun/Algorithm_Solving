package BOJ.JGeun.p1900;

import java.util.Scanner;

public class BOJ1912 {
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		int[] dp = new int[n];
		for(int i=0; i<n; i++) 
			num[i] = sc.nextInt();

		dp[0] = num[0];
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1]+num[i], num[i]);
		}
		int max = dp[0];
		for(int i=1; i<n; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}