package BOJ.p1700;

import java.util.Scanner;

public class BOJ1712 {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		final int A; int B, C;
		A = sc.nextInt(); B = sc.nextInt(); C = sc.nextInt();
		if(B>=C)
			System.out.println("-1");
		else{
			int revenue = C-B;
			int count = A /revenue;
			System.out.println(count+1);
		}
	}
}
