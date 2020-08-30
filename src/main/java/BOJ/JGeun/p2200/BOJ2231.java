package BOJ.JGeun.p2200;

import java.util.Scanner;

public class BOJ2231 {
	static int N;
	static int getSum(int n){
		String strN = Integer.toString(n);
		int len = strN.length();
		int sum=n;
		for(int i=0; i<len; i++){
			sum = sum + (strN.charAt(i)-'0');
		}
		return sum;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		boolean isMatch = false;
		for(int i=1; i<=N; i++){
			if(N==getSum(i)){
				System.out.println(i);
				isMatch=true;
				break;	
			}
		}
		if(!isMatch)
			System.out.println("0");
	}
}
