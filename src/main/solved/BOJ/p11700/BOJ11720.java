package BOJ.p11700;

import java.util.Scanner;

public class BOJ11720 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		String numLine = sc.nextLine();
		
		int sum = 0;
		for(int i=0; i<N; i++) 
			sum += (numLine.charAt(i)-'0');
		System.out.println(sum);
	}
}
