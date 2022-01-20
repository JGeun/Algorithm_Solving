package BOJ.p2900;

import java.util.Scanner;

public class BOJ2941 {
	static String[] cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
	static String[] sub = {"A", "B", "C", "D", "E", "F", "G", "H"};
	public static void main(String[] args){
		
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		word = changeToCro(word);
		System.out.println(word.length());
	}
	private static String changeToCro(String word){
		for(int i=0; i<8; i++)
			word = word.replace(cro[i], sub[i]);
		return word;
	}
}
