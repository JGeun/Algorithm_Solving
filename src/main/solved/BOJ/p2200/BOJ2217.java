package BOJ.p2200;

import java.util.*;

public class BOJ2217 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		int[] rope = new int[N];
		for(int i=0; i<N; i++)
			rope[i] =sc.nextInt();
		
		Arrays.sort(rope);
		long max =0;
		for(int i=0; i<N; i++) {
			int n = rope[i]*(N-i);
			if(max < n)
				max = n;
		}
		System.out.println(max);
	}
}
