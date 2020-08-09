package BOJ.JGeun.p11000;

import java.util.Scanner;

public class BOJ11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] num = new int[N+1];
		int[] dp = new int[N+1];
		
		for(int i=1; i<=N; i++)
			num[i] = sc.nextInt();
		
		for(int i=1; i<=N; i++) {
			for(int j=1; j<i; j++) {
				if(num[i] > num[j]) {
					dp[i] = Math.max(dp[i], dp[j]);
				}
			}
			dp[i] += 1;
		}
		int max = 0;
		for(int i=1; i<=N; i++) {
			if(max < dp[i])
				max = dp[i];
		}
		System.out.println(max);
	}
}
