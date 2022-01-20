package BOJ.p1100;

import java.util.Scanner;

public class BOJ1157 {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine().toUpperCase();
 
        int[] alpha = new int[26];
        int max = 0;
        char ch = '?';
 
        for (int i = 0; i < word.length(); i++) {
        	alpha[word.charAt(i) - 'A']+=1;
        	
            if (max < alpha[word.charAt(i) - 'A']) {
                max = alpha[word.charAt(i) - 'A'];
                ch = word.charAt(i);
            } 
            else if (max == alpha[word.charAt(i) - 'A']) {
            	ch = '?';
            }
        }
        System.out.println(ch);
    }
}
