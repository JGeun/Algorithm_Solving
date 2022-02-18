package BOJ.p11600;

import java.util.Scanner;

public class BOJ11653 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		int i=2;
		while(number != 1) {
			if(number % i == 0) {
				System.out.println(i);
				number /= i;
			}
			else
				i++;
		}
	}
}
