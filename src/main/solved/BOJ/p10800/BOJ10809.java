package BOJ.p10800;

import java.util.*;

public class BOJ10809 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		int[] alpha = new int[26];
		Arrays.fill(alpha, -1);
		for(int i=0; i<word.length(); i++) {
			int index = word.charAt(i)-'a';
			if(alpha[index] == -1)
				alpha[index] = i;
		}
		
		for(int i=0; i<alpha.length; i++)
			System.out.print(alpha[i] + " ");
	}
}
