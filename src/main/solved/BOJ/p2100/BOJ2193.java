package BOJ.p2100;

import java.util.Scanner;

public class BOJ2193 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int N = sc.nextInt();
		
		if(N==1 || N==2)
			System.out.println(1);
		else {
			long[] dp = new long[N+1];
			dp[1] = 1;
			dp[2] = 1;
			for(int i=3; i<=N; i++)
				dp[i] = dp[i-1] + dp[i-2];
			System.out.println(dp[N]);
		}
	}
}
