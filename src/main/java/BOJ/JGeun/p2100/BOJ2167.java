package BOJ.JGeun.p2100;

import java.util.Scanner;

public class BOJ2167 {
	public static void main(String[] args){
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt(), M = sc.nextInt();
    	
    	int[][] array = new int[N+1][M+1];
    	for(int i=1; i<=N; i++) {
    		for(int j=1; j<=M; j++)
    			array[i][j] = sc.nextInt();
    	}
    	
    	int K = sc.nextInt();
    	for(int a=0; a<K; a++) {
    		int i =sc.nextInt(), j =sc.nextInt(), x =sc.nextInt(), y =sc.nextInt();
    		int answer = 0;
			
			for(int b = i; b <= x; b++) {
				for(int c = j; c <= y; c++) {
					answer += array[b][c];
				}
			}
			System.out.println(answer);
    	}
    }
}
