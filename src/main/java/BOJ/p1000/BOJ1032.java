package BOJ.p1000;

import java.util.Scanner;

public class BOJ1032 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int N = Integer.parseInt(sc.nextLine());
		char[] word = sc.nextLine().toCharArray();
		for(int i=1; i<N; i++) {
			char[] compare = sc.nextLine().toCharArray();
			for(int j=0; j<word.length; j++){
				if(word[j] != compare[j])
					word[j] = '?';
			}
		}
		System.out.println(String.valueOf(word));
	}
}
