package BOJ.JGeun.p1900;

import java.util.Scanner;

public class BOJ1977 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt(), N=sc.nextInt();
		int[] arr = new int[N+1];
		int num = 1;
		while(num*num <= N) {
			arr[num*num] = 1;
			num +=1;
		}
		
		int min = 10001;
		int sum = 0;
		for(int i=M; i<=N; i++) {
			if(arr[i] == 1) {
				if(min > i) 
					min = i;
				
				sum += i;
			}
		}
		if(sum == 0)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}
	}
}
