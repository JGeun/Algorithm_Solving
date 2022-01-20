package BOJ.p1400;

import java.util.Scanner;

public class BOJ1475 {
	static int N;
	static int[] card;
	static void initCard(){
		card = new int[10];
		String num = String.valueOf(N);
		for(int i=0; i<num.length(); i++)
			card[num.charAt(i)-'0']+=1; 
		card[6] = card[6]+card[9];
		if(card[6]%2!=0)
			card[6] = card[6]/2+1;
		else
			card[6] = card[6]/2;
	}
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		initCard();
		int Max=card[0];
		for(int i=1; i<9; i++)
			if(Max<card[i])
				Max=card[i];
		System.out.println(Max);
	}
}
