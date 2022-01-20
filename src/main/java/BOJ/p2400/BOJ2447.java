package BOJ.p2400;

import java.util.*;

public class BOJ2447 {
	static char[][] star;
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		star = new char[N][N];
		
		for(int i=0; i<N; i++)
			Arrays.fill(star[i], ' ');
		
		dfs(0, 0, N);
		
		for(int i=0; i<N; i++)
			System.out.println(star[i]);
	}
	
	private static void dfs(int x, int y, int d) {
		if(d == 1) {
			star[y][x] = '*';
			return;
		}
		d /= 3;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(i==1 && j==1)
					continue;
				dfs(x+(j*d), y+(i*d), d);
			}
		}
	}
}
