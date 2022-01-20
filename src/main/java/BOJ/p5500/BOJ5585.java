package BOJ.p5500;

import java.util.Scanner;

public class BOJ5585 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] coin = {500, 100, 50, 10, 5, 1};
		int rest = 1000 - sc.nextInt();
		int count = 0;
		for(int i=0; i<coin.length; i++) {
			if(rest >= coin[i]) {
				count += rest/coin[i];
				rest = rest % coin[i];
			}
		}
		System.out.println(count);
	}
}
