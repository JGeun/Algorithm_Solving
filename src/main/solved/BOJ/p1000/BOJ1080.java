package BOJ.p1000;

import java.io.*;
import java.util.*;

public class BOJ1080 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, ans = 0;
    static int[][] A, B;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N][M];
        B = new int[N][M];

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                A[i][j] = line.charAt(j)-'0';
            }
        }

        for(int i=0; i<N; i++){
            String line = br.readLine();
            for(int j=0; j<M; j++){
                B[i][j] = line.charAt(j)-'0';
            }
        }
    }

    private static void process() throws IOException{
        if(N<3 || M <3){
            if(isSame(A, B)) ans = 0;
            else ans = -1;
        }else{
            findRange();
            if(!isSame(A, B)) ans = -1;
        }
        System.out.println(ans);
    }

    private static void findRange() {
        for(int i=0; i<N-2; i++){
            for(int j=0; j<M-2; j++){
                if(A[i][j] != B[i][j]){
                    flip(i, j);
                    ans+=1;
                }
            }
        }
    }

    private static void flip(int r, int c){
        for(int i=r; i<r+3; i++){
            for(int j=c; j<c+3; j++){
                A[i][j] = A[i][j] == 1 ? 0 : 1;
            }
        }
    }

    private static boolean isSame(int[][] A, int[][] B){
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(A[i][j] != B[i][j]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
