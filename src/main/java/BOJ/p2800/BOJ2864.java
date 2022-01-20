package BOJ.p2800;

import java.util.Scanner;

public class BOJ2864 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String s1 = sc.next();
		String s2 = sc.next();
		
		System.out.println(Integer.parseInt(StoF(s1)) + Integer.parseInt(StoF(s2)));
		System.out.println(Integer.parseInt(FtoS(s1)) + Integer.parseInt(FtoS(s2)));
	}
	private static String FtoS(String num) {
		return num.replace("5", "6");
	}
	private static String StoF(String num){
		return num.replace("6", "5");
	}
}
