package BOJ.JGeun.p1000;

import java.util.*;

public class BOJ1003 {
	static int T;
	static long[] arr = new long[41];
	static long fibo(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		if(arr[n] != 0)
			return arr[n];
		arr[n] = fibo(n-1) +fibo(n-2);
		return arr[n];
	}
	static void printFiboCount(int n){
		if(n==0)
			System.out.println("1 0");
		else if(n==1)
			System.out.println("0 1");
		else
			System.out.println(fibo(n-1)+" "+fibo(n));
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		T=sc.nextInt();
		for(int i=0; i<T; i++){
			int N = sc.nextInt();
			printFiboCount(N);
		}
	}
}
