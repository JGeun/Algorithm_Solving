package BOJ.p2500;

import java.util.Scanner;

public class BOJ2581 {
	static boolean isPrime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static void find_minP(int min, int max) {
		for (int i = min; i <= max; i++) {
			if (isPrime(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	static int findSum(int min, int max) {
		int sum = 0;
		for (int i = min; i <= max; i++) {
			if (isPrime(i)) {
				sum += i;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();

		int sum = findSum(M, N);
		if (sum == 0)
			System.out.println("-1");
		else {
			System.out.println(sum);
			find_minP(M, N);
		}
	}
}
