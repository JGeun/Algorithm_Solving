package BOJ.JGeun.p1500;

import java.util.Scanner;

public class BOJ1546 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		
		int N = sc.nextInt();
		int max = 0;
		int sum = 0;
		for(int i=0; i<N; i++) {
			int num = sc.nextInt();
			sum += num;
			if(num > max)
				max = num;
		}
		System.out.println((double)100*sum/max/N);
	}
}
