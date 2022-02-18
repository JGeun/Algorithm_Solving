package BOJ.p2200;

import java.util.*;
import java.io.*;

public class BOJ2206 {
	static int N, M, ans;
	static int[][] map;
	static boolean[][][] visit;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		map = new int[N+1][M+1];
		visit = new boolean[N+1][M+1][2];
		
		for(int i=1; i<=N; i++) {
			str = br.readLine().split("");
			for(int j=1; j<=M; j++) {
				map[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		bfs(1, 1);
	}
	public static void bfs(int y, int x){
		Queue<Place> q = new LinkedList<>();
		q.add(new Place(x, y, 1, 0));
		visit[y][x][0] = true;
		visit[y][x][1] = true;
		
		while(!q.isEmpty()) {
			Place p = q.poll();
			
			if(p.y == N && p.x == M) {
				System.out.println(p.dis);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				
				if(ny<=0 || nx <=0 || ny>N || nx>M)
					continue;
				
				if(map[ny][nx] == 1){
					if(p.wall == 0 && !visit[ny][nx][1]) {
						visit[ny][nx][1] = true;
						q.add(new Place(nx, ny, p.dis+1, p.wall+1));
					}
				}else{
					if(!visit[ny][nx][p.wall]) {
						q.add(new Place(nx, ny, p.dis+1, p.wall));
						visit[ny][nx][p.wall] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}

class Place{
	int x;
	int y;
	int dis;
	int wall;
	
	public Place(int x, int y, int dis, int wall) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.wall = wall;
	}
}