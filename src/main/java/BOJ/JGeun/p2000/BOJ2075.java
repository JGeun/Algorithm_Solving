package BOJ.JGeun.p2000;

import java.io.*;
import java.util.*;

public class BOJ2075 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) pq.add(Integer.parseInt(st.nextToken()));
        }
    }

    static void process(){
        for(int i=1; i<=N-1; i++)pq.poll();
        System.out.println(pq.peek());
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
