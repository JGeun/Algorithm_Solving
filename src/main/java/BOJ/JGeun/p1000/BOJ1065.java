package BOJ.JGeun.p1000;

import java.util.Scanner;

public class BOJ1065 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		for(int i=1; i<=N; i++) {
			if(isSeq(i)){
				count+=1;
			}
		}
		System.out.println(count);
	}
	private static boolean isSeq(int n) {
		if (n < 100) {
			return true;
		}
		else if (n < 1000) {
			int[] num = new int[3];
			for (int i = 0; i < 3; i++) {
				num[i] = n % 10;
				n /= 10;
			}
			if ((num[2] - num[1]) != (num[1] - num[0]))
				return false;
			return true;
		}
		else
			return false;
	}
}
