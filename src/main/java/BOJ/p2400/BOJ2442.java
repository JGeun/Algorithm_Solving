package BOJ.p2400;

import java.util.*;

public class BOJ2442 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i=0; i<N; i++){
			for(int j=0; j<(N-1)-i; j++)
				System.out.print(" ");
			for(int z=0; z<2*(i+1)-1; z++)
				System.out.print("*");
			System.out.print("\n");
		}
	}
}
