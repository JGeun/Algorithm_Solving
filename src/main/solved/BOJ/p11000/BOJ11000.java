package BOJ.p11000;

import java.io.*;
import java.util.*;

public class BOJ11000 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] room;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        room = new int[N][2];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            room[i][0] = S;
            room[i][1] = T;
        }
    }

    static void process(){
        Arrays.sort(room, (o1, o2)->{
            if(o1[0] != o2[0]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(room[0][1]);

        for(int i=1; i<N; i++){
            if(pq.peek() <= room[i][0]) pq.poll();
            pq.add(room[i][1]);
        }
        System.out.println(pq.size());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
