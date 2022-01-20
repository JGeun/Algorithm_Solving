package BOJ.p2900;

import java.util.*;

public class BOJ2902 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		String word = sc.nextLine();
		StringTokenizer st = new StringTokenizer(word, "-");
		String answer = "";
		while(st.hasMoreTokens()) {
			answer += st.nextToken().substring(0,1);
		}
		System.out.println(answer);
	}
}
