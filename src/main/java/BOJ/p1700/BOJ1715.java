package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1715 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] cards;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        cards = new int[N];
        for(int i=0; i<N; i++) cards[i] = Integer.parseInt(br.readLine());
    }

    static void process(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<cards.length; i++) pq.add(cards[i]);

        int ans = 0;
        while(pq.size() != 1){
            int n1 = pq.poll();
            int n2 = pq.poll();
            ans += n1+n2;
            pq.add(n1+n2);
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
