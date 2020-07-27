package BOJ.JGeun.p2800;

import java.util.*;

public class BOJ2847 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] score = new int[N];
		for(int i=0; i<N; i++)
			score[i] = sc.nextInt();
		
		int count =0;
		int max = score[N-1];
		for(int i=N-2; i>=0; i--) {
			while(score[i] >= max) {
				score[i]-=1;
				count+=1;
			}
			max = score[i];
		}
		System.out.println(count);
	}
}
