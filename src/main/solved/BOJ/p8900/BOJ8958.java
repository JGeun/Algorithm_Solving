package BOJ.p8900;

import java.util.Scanner;

public class BOJ8958 {
	public static void main(String[] args){
		Scanner sc= new Scanner(System.in);
		int N =Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<N; i++) {
			String quiz = sc.nextLine();
			int score = 0;
			int num = 0;
			for(int j=0; j<quiz.length(); j++){
				if(quiz.charAt(j) == 'X')
					num = 0;
				else
					num +=1;
				score += num;
			}
			System.out.println(score);
		}
	}
}
