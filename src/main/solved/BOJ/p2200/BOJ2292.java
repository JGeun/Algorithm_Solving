package BOJ.p2200;

import java.util.Scanner;

public class BOJ2292 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int floor = 1, sum = 1, count =1;
		
		while(N > sum){
			sum += (floor++)*6;
			count +=1;
		}
		System.out.println(count);
	}
}
