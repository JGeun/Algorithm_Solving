package BOJ.p2500;

import java.util.Scanner;

public class BOJ2577 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int A = sc.nextInt(), B=sc.nextInt(), C=sc.nextInt();
		String number = Integer.toString(A*B*C);
		int[] num = new int[10];
		for(int i=0; i<number.length(); i++)
			num[number.charAt(i)-'0']+=1;
		for(int i=0; i<10; i++)
			System.out.println(num[i]);
	}
}
