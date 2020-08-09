package BOJ.JGeun.p11600;

import java.util.*;

public class BOJ11656 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		String[] words = new String[word.length()];
		for(int i=0; i<word.length(); i++) 
			words[i] = word.substring(i, word.length());
		Arrays.sort(words);
		
		for(int i=0; i<words.length; i++)
			System.out.println(words[i]);
	}
}
