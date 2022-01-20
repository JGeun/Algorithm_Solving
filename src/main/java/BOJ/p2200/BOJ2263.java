package BOJ.p2200;

import java.io.*;
import java.util.*;

public class BOJ2263 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, index = 0;
    static int[] pre, in, post;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        pre = new int[N];
        in = new int[N];
        post = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) in[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) post[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        inputPre(0, N-1, 0,N-1);

        for(int i=0; i<N; i++){
            sb.append(pre[i]);
            if(i != N-1) sb.append(' ');
        }
        System.out.println(sb);
    }

    static void inputPre(int pL, int pR, int iL, int iR){
        if(pL <= pR && iL <= iR){
            pre[index++] = post[pR];
            int child = findNode(post[pR], iL, iR); //inOrder에서 중심노드의 idx 얻기

            inputPre(pL, pL+child-iL-1, iL, child-1);
            inputPre(pL+child-iL, pR-1, child+1, iR);
        }
    }

    static int findNode(int node, int L, int R){
        for(int i=L; i<=R; i++){
            if(in[i] == node) return i;
        }
        return L;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
