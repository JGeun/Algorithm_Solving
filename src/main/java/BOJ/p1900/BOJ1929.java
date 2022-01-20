package BOJ.p1900;

import java.util.Scanner;

public class BOJ1929 {
	static int M, N;
	static int[] arr;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); N = sc.nextInt();
		arr = new int[N+1]; // 0~15
		arr[0] = 0; arr[1] = 0;
		for(int k=2; k<=N; k++)
			arr[k] = k;
		for(int i=2; i<=(int)Math.sqrt(N); i++){
			if(arr[i] == 0)
				continue;
			int mul=2;
			while(N>=i*mul){
				arr[i*mul] = 0;
				mul+=1;
			}
		}
		for(int i=M; i<=N; i++)
			if(arr[i] != 0)
				System.out.println(i);
	}
}
