package BOJ.p2400;

import java.io.*;
import java.util.*;

public class BOJ2468 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, max=0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;
    static ArrayList<Integer> list;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        visit = new boolean[N+1][N+1];
        list = new ArrayList<>();
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
                max = Math.max(max, value);
            }
        }
    }

    static void DFS(int x, int y, int h){
        visit[x][y] = true;

        for(int i=0; i<4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(fx>=1 && fy >=1 && fx<= N && fy<=N){
                if(map[fx][fy] > h && !visit[fx][fy]){
                    DFS(fx,fy,h);
                }
            }
        }
    }

    static void process(){
        for(int h=0; h<=max; h++){
            int cnt = 0;
            for(boolean[] v: visit) Arrays.fill(v, false);
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(!visit[i][j] && map[i][j] > h){
                        cnt+=1;
                        DFS(i,j, h);
                    }
                }
            }
            list.add(cnt);
        }
        System.out.println(Collections.max(list));
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
