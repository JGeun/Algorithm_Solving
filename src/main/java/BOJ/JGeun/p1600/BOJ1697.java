package BOJ.JGeun.p1600;

import java.util.*;

public class BOJ1697 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(), K = sc.nextInt();
		int[] Min = new int[100001];
		Arrays.fill(Min, -1);
		System.out.println(BFS(N, K, Min));
	}
	private static int BFS(int N, int K, int[] Min) {
		int nextN = N;
		int[] pos = new int[3];
		Queue<Integer> q = new LinkedList<>();
		q.add(nextN);
		Min[nextN] = 0;
		
		while(!q.isEmpty() && nextN != K) {
			nextN = q.poll();
			
			pos[0] = nextN-1;
			pos[1] = nextN+1;
			pos[2] = nextN*2;
			
			for(int i=0; i<3; i++) {
				if(pos[i]>=0 && pos[i] <= 100000) {
					if(Min[pos[i]] == -1) {
						q.add(pos[i]);
						Min[pos[i]] = Min[nextN] +1;
					}
				}
			}
		}
		return Min[K];
	}
}
