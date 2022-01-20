package BOJ.p10200;

import java.util.Scanner;

public class BOJ10250 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int H = sc.nextInt(), W=sc.nextInt(), N= sc.nextInt();
			int floor = N%H;
			if(floor == 0)
				floor = H;
			int number = (N-1)/H+1;
			System.out.println(floor*100+number);
		}
	}
}
