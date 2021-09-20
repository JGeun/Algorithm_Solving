package BOJ.JGeun.p1900;

import java.io.*;
import java.util.*;

public class BOJ1946 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] score;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        score = new int[N+1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            score[x] = y;
        }
    }

    static void process() {
        int ans = 1;
        int std = score[1];
        for(int i=2; i<=N; i++){
            if(std > score[i]) {
                ans += 1;
                std = score[i];
            }
        }
        sb.append(ans).append('\n');
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while(T-->0){
            input();
            process();
        }
        System.out.print(sb);
    }
}
