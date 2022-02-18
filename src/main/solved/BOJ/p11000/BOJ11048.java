package BOJ.p11000;

import java.io.*;
import java.util.*;

public class BOJ11048 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[][] map;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        map = new int[N+1][M+1];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++) map[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static void process(){
        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){
                map[i][j] = map[i][j] + Math.max(map[i][j-1], Math.max(map[i-1][j], map[i-1][j-1]));
            }
        }
        System.out.println(map[N][M]);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
