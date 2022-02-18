package BOJ.p2200;

import java.util.*;

public class BOJ2293 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k=sc.nextInt();
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++)
			coin[i] = sc.nextInt();
		Arrays.sort(coin);
		
		dp[0] = 1;
		for(int i=0; i<n; i++) {
			for(int j=coin[i]; j<=k; j++) {
				dp[j] += dp[j-coin[i]];
			}
		}
		System.out.println(dp[k]);
	}
}	
