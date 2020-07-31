package BOJ.JGeun.p5500;

import java.util.Scanner;

public class BOJ5565 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = sc.nextInt();
		for(int i=0; i<9; i++) 
			total -= sc.nextInt();
		System.out.println(total);
	}
}
