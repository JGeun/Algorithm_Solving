package BOJ.p1000;

import java.util.Scanner;

public class BOJ1010 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			int N=sc.nextInt(),M=sc.nextInt();
			int[][] array = new int[N][M];
			
			for(int j=0; j<M; j++)
				array[0][j] = 1;
			
			for(int k=1; k<N; k++) {
				int sum = 0;
				for(int j=1; j<=M-k; j++)
					sum += array[k-1][j];
				
				for(int j=0; j<M-k; j++){
					array[k][j] = sum;
					sum -= array[k-1][j+1];
				}
			}
			int sumT = 0;
			for(int j=0; j<=M-N; j++) 
				sumT += array[N-1][j];
			System.out.println(sumT);
		}
	}
}
