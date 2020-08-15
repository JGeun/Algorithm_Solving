package BOJ.JGeun.p10900;

import java.util.Scanner;

public class BOJ10987 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		char[] words = sc.nextLine().toCharArray();
		char[] vowel = {'a', 'e', 'i', 'o', 'u'};
		
		int count = 0;
		for(int i=0; i<words.length; i++) {
			for(int j=0; j<5; j++) {
				if(words[i] == vowel[j])
					count +=1;
			}
		}
		System.out.println(count);
	}
}
