package BOJ.p2900;

import java.util.Scanner;

public class BOJ2960 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(), K =sc.nextInt();
		int[] era = new int[N+1];
		getEra(N, K, era);
		
	}
	private static void getEra(int N, int K, int[] era) {
		int pos =2, count=0;
		
		while(pos != N+1) {
			if(era[pos] != 1) {
				for(int i=pos; i<=N; i+=pos) {
					if(era[i] != 1) {
						era[i] = 1;
						count += 1;
						if(count == K) {
							System.out.println(i);
							return;
						}
					}
				}
			}
			pos+=1;
		}
		System.out.println(N);
	}
}
