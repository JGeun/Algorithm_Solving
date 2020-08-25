package BOJ.JGeun.p3000;

import java.util.Scanner;

public class BOJ3053 {
	static int R;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		System.out.printf("%.6f\n", Math.PI*R*R);
		System.out.printf("%.6f\n", (double)R*R*2);
	}
}
