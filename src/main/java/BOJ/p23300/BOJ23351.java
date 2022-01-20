package BOJ.p23300;

import java.io.*;
import java.util.*;

public class BOJ23351 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K, A, B, ans = 1;
    static int[] pots;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        pots = new int[N];
        Arrays.fill(pots, K);
    }

    static void process(){
        int index = 0;
        while(true){
            for(int i=index; i<index+A; i++) pots[i%N] += B;
            for(int i=0; i<N; i++){
                if(--pots[i] == 0){
                    System.out.println(ans);
                    return;
                }
            }
            ans += 1;
            index = (index+A)%N;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
