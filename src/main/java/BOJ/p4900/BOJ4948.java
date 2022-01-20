package BOJ.p4900;

import java.util.Scanner;

public class BOJ4948 {
	static int n;
	static boolean isPrime(int n){
		if(n==1)
			return false;		
		for(int i=2; i<=(int)Math.sqrt(n); i++)
			if(n%i == 0)
				return false;
		return true;
	}
	static int getPrimeCount(int n){
		int count=0;
		for(int i=n+1; i<=2*n; i++)
			if(isPrime(i))
				count++;
		return count;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		while(true){
			n = sc.nextInt();
			if(n == 0) break;
			System.out.println(getPrimeCount(n));
		}
	}
}
