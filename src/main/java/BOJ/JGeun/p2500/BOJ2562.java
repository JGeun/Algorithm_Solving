package BOJ.JGeun.p2500;

import java.util.Scanner;

public class BOJ2562 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int max = 0, max_pos=0;
		for(int i=1; i<=9; i++){
			int num = sc.nextInt();
			if(max < num){
				max = num;
				max_pos = i;
			}
		}
		System.out.println(max);
		System.out.println(max_pos);
	}
}
