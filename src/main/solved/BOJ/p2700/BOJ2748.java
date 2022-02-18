package BOJ.p2700;

import java.util.Scanner;

public class BOJ2748 {
	static int N;
	static long[] arr;
	static long fibonacci(int n){
		if(arr[n] != 0)
			return arr[n];
		if(n==0)
			return 0;
		if(n==1)
			return 1;
		else
			arr[n] = fibonacci(n-1) + fibonacci(n-2);
		return arr[n];
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new long[N+1];
		System.out.println(fibonacci(N));
	}
}
