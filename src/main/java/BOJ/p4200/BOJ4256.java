package BOJ.p4200;

import java.util.*;
import java.io.*;

public class BOJ4256 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, index;
    static int[] pre, in, post;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        post = new int[N+1];
        pre = new int[N+1];
        in = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) pre[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) in[i] = Integer.parseInt(st.nextToken());
    }

    static void inputPost(int pL, int pR, int iL, int iR){
        if(pL <= pR && iL <= iR){
            post[index--] = pre[pL];

            for(int i=iL; i<=iR; i++){
                if(in[i] == pre[pL]){
                    int preLSize = i-iL;
                    inputPost(pL+preLSize+1, pR, i+1, iR);
                    inputPost(pL+1, pL + preLSize, iL, i-1);
                }
            }
        }
    }

    static void process() {
        index = N;
        inputPost(1, N, 1, N);

        for(int i=1; i<=N; i++) {
            sb.append(post[i]);
            if (i != N) sb.append(' ');
        }
        sb.append('\n');
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
