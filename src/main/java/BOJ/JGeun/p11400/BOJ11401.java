package BOJ.JGeun.p11400;

import java.io.*;
import java.util.*;

class BOJ11401 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K;
    static long MOD = 1000000007;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }

    static void process() {
        long up = factorial(N);
        long down = factorial(K) * factorial(N-K) % MOD;
        System.out.println(up*pow(down, MOD-2) % MOD);
    }

    static long factorial(long N){
        long fac = 1L;

        while(N > 1){
            fac = (fac*N)%MOD;
            N--;
        }
        return fac;
    }

    static long pow(long base, long expo){
        if(expo == 1) return base % MOD;
        long result = pow(base, expo/2);
        if(expo % 2 == 1) return (result*result%MOD)*base%MOD;
        return result*result%MOD;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
