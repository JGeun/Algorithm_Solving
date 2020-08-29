package BOJ.JGeun.p11700;

import java.util.Scanner;

public class BOJ11729 {
	static int N;
	static StringBuffer sb = new StringBuffer();
	static void hanoi(int n, int from, int by, int to){
		if(n==1){
			sb.append(from+" "+to+"\n");
		}
		else{
			hanoi(n-1, from, to, by);
			sb.append(from+" "+to+"\n");
			hanoi(n-1, by, from, to);
		}
	} 
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int K = (int)Math.pow(2,N)-1;
		sb.append(K+"\n");
		hanoi(N,1,2,3);
		System.out.println(sb);
	}
}	
