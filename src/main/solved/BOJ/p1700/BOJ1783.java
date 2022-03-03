package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1783 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
    }

    static int process(){
        if(N == 1) return 1;
        if(N == 2) return Math.min(4, (M+1)/2);
        if(M<7) return Math.min(4, M);
        return M-2;
    }

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(process());
    }
}
