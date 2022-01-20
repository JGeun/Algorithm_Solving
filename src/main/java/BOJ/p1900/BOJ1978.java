package BOJ.p1900;

import java.util.Scanner;

public class BOJ1978 {
	static int N;
	static int[] arr;
	static boolean isPrime(int n){{
		if(n==1) return false;
		else{
			for(int k=2; k<n; k++)
				if(n%k==0)
					return false;
			}
		}
		return true;
	}
	static int getPrimeCount(int[] arr){
		int count=0;
		for(int i=0; i<arr.length; i++)
			if(isPrime(arr[i]))
				count+=1;
		return count;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N =sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		System.out.println(getPrimeCount(arr));
	}
}
