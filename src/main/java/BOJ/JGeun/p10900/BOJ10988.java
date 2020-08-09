package BOJ.JGeun.p10900;

import java.util.Scanner;

public class BOJ10988 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		StringBuilder sb = new StringBuilder(word);
		if(sb.reverse().toString().equals(word))
			System.out.println(1);
		else
			System.out.println(0);
	}
}
