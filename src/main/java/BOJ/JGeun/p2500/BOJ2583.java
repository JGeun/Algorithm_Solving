package BOJ.JGeun.p2500;

import java.io.*;
import java.util.*;

public class BOJ2583 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int M,N,K, cnt =0;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visit;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visit = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++){
                for(int x=x1; x<x2; x++){
                    map[y][x] = 1;
                }
            }
        }
    }

    static void DFS(int y, int x) {
        cnt+=1;
        visit[y][x] = true;

        for(int i=0; i<4; i++){
            int fx = x + dx[i];
            int fy = y + dy[i];
            if(fx>=0 && fy>=0 && fy<M && fx<N){
                if(!visit[fy][fx] && map[fy][fx] == 0) DFS(fy,fx);
            }
        }
    }

    static void process() {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<M; i++){
            for(int j=0; j<N; j++){
                if(!visit[i][j] && map[i][j] == 0){
                    cnt = 0;
                    DFS(i,j);
                    list.add(cnt);
                }
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i));
            if(i != list.size()-1) sb.append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
