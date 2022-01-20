package BOJ.p1100;

import java.util.Scanner;

public class BOJ1110 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 0;
		int num = N;
		do {
			num = (num/10+num%10)%10+num%10*10;
			count+=1;
		}while(N != num);
		System.out.println(count);
	}
}
