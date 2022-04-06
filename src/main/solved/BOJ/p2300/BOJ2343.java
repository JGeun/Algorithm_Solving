package BOJ.p2300;

import java.util.*;
import java.io.*;

public class BOJ2343{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[] A;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());
    }

    static boolean determination(int K){
        int cnt = 0, sum = 0;
        for (int i = 1; i <= N; i++) {
            if(sum + A[i] == K){
                cnt++;
                sum = 0;
            }else if (sum + A[i] > K) {
                cnt++;
                sum = A[i];
            } else {
                sum += A[i];
            }
        }

        if(sum != 0)
            cnt += 1;
        return cnt <= M;
    }

    static void setBluelaySize(){
        int L=A[1], R=1000000000, ans = 0;
        for(int i= 1; i<=N; i++)
            L = Math.max(L, A[i]);

        while(L <= R){
            int mid = (L+R)/2;
            if(determination(mid)) {
                ans = mid;
                R = mid - 1;
            }else{
                L = mid + 1;
            }
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        setBluelaySize();
    }
}

