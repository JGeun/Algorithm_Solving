package BOJ.p2400;

import java.util.*;

public class BOJ2445 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=i; j++)
				System.out.print("*");
			for(int k=1; k<=2*(N-i); k++)
				System.out.print(" ");
			for(int z=1; z<=i; z++)
				System.out.print("*");
			System.out.print("\n");
		}
		for(int i=N-1; i>=1; i--){
			for(int j=1; j<=i; j++)
				System.out.print("*");
			for(int k=1; k<=2*(N-i); k++)
				System.out.print(" ");
			for(int z=1; z<=i; z++)
				System.out.print("*");
			System.out.print("\n");
		}
	}
}
