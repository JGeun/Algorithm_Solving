package BOJ.JGeun.p1000;

import java.util.Scanner;

public class BOJ1012 {
	private static int M, N, cnt;
	private static int[][] map;
	private static boolean[][] visited;
	static int dx[] = {-1,1,0,0};
	static int dy[] = {0,0,-1,1};
	
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i=0; i<T; i++) {
			M = sc.nextInt(); N = sc.nextInt();
			int K = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for(int j=0; j<K; j++) {
				int X = sc.nextInt(), Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			cnt = 0;
			for(int a=0; a<N; a++) {
				for(int b=0; b<M; b++) {
					if(map[a][b] == 1 && !visited[a][b]) {
						checkMap(a, b);
						cnt += 1;
					}
				}
			}
			System.out.println(cnt);
		}
	}
	public static void checkMap(int y, int x) {
		visited[y][x] = true;
		
		for(int i=0; i<4; i++) {
			int fx = x+dx[i];
			int fy = y+dy[i];
			
			if(fx>=0 && fy>=0 && fx<M && fy < N) {
				if(map[fy][fx] == 1 && !visited[fy][fx]) {
					checkMap(fy,fx);
				}
			}
		}
	}
}
