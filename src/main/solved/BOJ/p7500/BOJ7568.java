package BOJ.p7500;

import java.util.*;

public class BOJ7568 {	
	static int N;
	static int person[][];
	static int[] rank;
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		person = new int[N][N];
		rank = new int[N]; Arrays.fill(rank, 1);
		for(int i=0; i<N; i++)
			for(int j=0; j<2; j++)
				person[i][j] = sc.nextInt();
 
		for(int k=0; k<N; k++){
			for(int z=0; z<N; z++){
				if(k==z)
					continue;
				if((person[k][0] < person[z][0]) && (person[k][1] < person[z][1]))
					rank[k]+=1;
			}
			System.out.print(rank[k]+" ");
		}
	}
}
