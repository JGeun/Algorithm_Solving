package BOJ.p3000;

import java.util.Scanner;

public class BOJ3009 {
	static int findNotEqual(int n1, int n2, int n3){
		if(n1 != n2){
			if(n1 == n3)
				return n2;
			else
				return n1;
		}
		return n3;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int x1=sc.nextInt(), y1=sc.nextInt();
		int x2=sc.nextInt(), y2=sc.nextInt();
		int x3=sc.nextInt(), y3=sc.nextInt();
		
		System.out.println(findNotEqual(x1,x2,x3)+" "+findNotEqual(y1,y2,y3));
	}
}
