package BOJ.p10800;

import java.util.Scanner;

public class BOJ10872 {
	public static int fac(int N){
		if(N==0)
			return 1;
		else
			return fac(N-1) * N;
	}
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fac(N));
	}
}
