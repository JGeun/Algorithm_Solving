package BOJ.JGeun.p10700;

import java.util.Scanner;

public class BOJ10797 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		
		int day = sc.nextInt();
		for(int i=0; i<5; i++) {
			int num = sc.nextInt();
			if(num == day)
				count += 1;
		}
		System.out.println(count);
	}
}
