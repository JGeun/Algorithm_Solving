package BOJ.JGeun.p2400;

import java.util.*;

public class BOJ2443 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++){
			for(int z=0; z<i; z++)
				System.out.print(" ");
			for(int j=0; j<2*(N-i)-1; j++)
				System.out.print("*");
			System.out.print("\n");
		}
	}
}
