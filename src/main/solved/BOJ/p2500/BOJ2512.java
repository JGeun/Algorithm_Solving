package BOJ.p2500;

import java.util.*;
import java.io.*;

public class BOJ2512 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[] A;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
    }

    static boolean determination(int budget, int M){
        int totalBudget = 0;
        for(int i=1; i<=N; i++)
            totalBudget += Math.min(A[i], budget);
        return totalBudget <= M;
    }

    static void setBudget(){
        Arrays.sort(A, 1, N+1);

        int L=1, R=A[N], ans = R+1;
        while(L <= R){
            int mid = (L+R)/2;
            if(determination(mid, M)) {
                ans = mid;
                L = mid + 1;
            }else{
                R = mid - 1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        setBudget();
    }
}

