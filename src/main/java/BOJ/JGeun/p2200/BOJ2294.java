package BOJ.JGeun.p2200;

import java.util.*;

public class BOJ2294 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), k=sc.nextInt();
		int[] coin = new int[n];
		int[] dp = new int[k+1];
		
		for(int i=0; i<n; i++)
			coin[i] = sc.nextInt();
		Arrays.sort(coin);
		
		for(int i=1; i<=k; i++)
			dp[i] = k+1;
		dp[0] =0;
		
		if(k < coin[0])
			System.out.println(-1);
		else {
			for(int i=coin[0]; i<=k; i++) {
				for(int j=0; j<n; j++){
					if(coin[j] > i)
						break;
					else 
						dp[i] = Math.min(dp[i]-1, dp[i-coin[j]])+1;
				}
			}
			
			if(dp[k] == k+1)
				System.out.println(-1);
			else
				System.out.println(dp[k]);
		}
	}
}
