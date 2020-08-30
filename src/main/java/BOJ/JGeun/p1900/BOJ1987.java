package BOJ.JGeun.p1900;

import java.util.Scanner;

public class BOJ1987 {
	static int[] dx ={-1,1,0,0};
	static int[] dy = {0,0, -1, 1};
	static int R, C;
	static char[][] alpha;
	static char[] visit;
	static int max = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt(); C = sc.nextInt();
		visit = new char[R*C];
		alpha = new char[R][C];
		
		sc.nextLine();
		for(int i=0; i<R; i++) {
			String board = sc.nextLine();
			for(int j=0; j<C; j++)
				alpha[i][j] = board.charAt(j);
		}
			
		visit[0] = alpha[0][0];
		dfs(0, 0, 1, 1);
		System.out.println(max);
	}
	private static void dfs(int y, int x, int pos, int count) {
		for(int i=0; i<4; i++) {
			int fx = x+dx[i];
			int fy = y+dy[i];
			
			if(fx>=0 && fy>=0 && fx<C && fy<R) {
				boolean isSame = false;
				for(int j=0; j<pos; j++) {
					if(visit[j] == alpha[fy][fx]) {
						isSame = true;
						break;
					}
				}
				if(!isSame) {
					visit[pos] = alpha[fy][fx];
					dfs(fy, fx, pos+1, count+1);
					visit[pos] = '0';
				}
			}
		}
		
		if(max < count)
			max=count;
		return;
	}
}
