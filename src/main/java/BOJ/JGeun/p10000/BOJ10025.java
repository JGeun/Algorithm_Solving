package BOJ.JGeun.p10000;

import java.io.*;
import java.util.*;

public class BOJ10025 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K;
    static int[] a;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        a = new int[1000001];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int g = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            a[x] = g;
        }
    }

    static void process(){
        int sum = 0;
        int max = 0;
        int window = 1 +(2*K);

        for(int i=0; i<=1000000; i++){
            if(i >= window) sum -= a[i-window];
            sum += a[i];
            if(sum > max) max = sum;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
