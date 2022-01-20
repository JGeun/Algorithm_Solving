package BOJ.p2800;

import java.util.Scanner;

public class BOJ2869 {
	static double A, B, V;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		A = sc.nextDouble(); B =sc.nextDouble(); V = sc.nextDouble();
		if(V == A)
			System.out.println("1");
		else
			System.out.println( (long)Math.ceil((V-A)/(A-B))+1);
	}
}
