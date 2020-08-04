package BOJ.JGeun.p10800;

import java.util.Scanner;

public class BOJ10808 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		int[] alpha = new int[26];
		for(int i=0; i<word.length(); i++)
			alpha[word.charAt(i)-'a']+=1;
		
		for(int i=0; i<26; i++)
			System.out.print(alpha[i]+ " ");
	}
}
