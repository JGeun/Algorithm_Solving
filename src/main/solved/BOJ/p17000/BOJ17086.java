package BOJ.p17000;

import java.io.*;
import java.util.*;

public class BOJ17086 {
    private static int N, M;
    private static int[][] map;
    private static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1}; //상하
    private static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1}; //좌우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 1)
                    checkBlock(i, j);
            }
        }

        int ans = 0;
        for(int i=0; i<N; i++) {
            for (int j = 0; j < M; j++)
                ans = Math.max(ans, map[i][j]);
        }
        System.out.println(ans-1);
    }

    private static void checkBlock(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while(!queue.isEmpty()){
            int[] pos = queue.poll();
            for(int i=0; i<8; i++){
                int fx = pos[0] + dx[i];
                int fy = pos[1] + dy[i];

                if(fx>=0 && fy>=0 && fx<N && fy<M){
                    if(map[fx][fy] == 0 || map[fx][fy] > map[pos[0]][pos[1]] + 1){
                        map[fx][fy] = map[pos[0]][pos[1]] + 1;
                        queue.add(new int[]{fx, fy});
                    }
                }
            }
        }
    }
}
