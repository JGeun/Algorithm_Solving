package BOJ.p2700;

import java.util.Scanner;

public class BOJ2798 {
	static int N, M;
	static int[] card;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); M=sc.nextInt();
		card = new int[N];
		for(int a=0; a<N; a++)
			card[a] = sc.nextInt();
		int Max=0, sum=0;
		for(int i=0; i<N; i++){
			for(int j=i+1; j<N; j++){
				for(int k=j+1; k<N; k++){
					sum = card[i] + card[j] + card[k];
					if(sum <= M && Max<sum)
						Max = sum;
				}
			}
		}
		System.out.println(Max);
	}
}
