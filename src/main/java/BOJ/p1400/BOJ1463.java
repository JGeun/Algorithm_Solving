package BOJ.p1400;

import java.util.Scanner;

public class BOJ1463 {
	static int n;
	static int[] dp;
	static void getCount(int num){
		for(int i=2; i<=num; i++){
			int min=1000000;
			if(i%3 == 0){
				if(min > dp[i/3])
					min = dp[i/3]+1;
			}
			if(i%2==0){
				if(min > dp[i/2])
					min = dp[i/2]+1;
			} 
			if(min>dp[i-1])
				min = dp[i-1]+1;
			dp[i] = min;
		}
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dp = new int[n+1];
		dp[0] = 0; dp[1] = 0;
		getCount(n);
		System.out.println(dp[n]);
	}
}
