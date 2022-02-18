package BOJ.p2100;

import java.io.*;
import java.util.*;

public class BOJ2143 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int T, N, M;
    static int[] A, B;
    static ArrayList<Integer> A_sum, B_sum;

    static void input() throws IOException {
        T = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) A[i] = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());
        B = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) B[i] = Integer.parseInt(st.nextToken());
    }

    static void process(){
        A_sum = new ArrayList<>();
        B_sum = new ArrayList<>();

        for(int i=0; i<N; i++){
            int sum = 0;
            for(int j=i; j<N; j++){
                sum += A[j];
                A_sum.add(sum);
            }
        }

        for(int i=0; i<M; i++){
            int sum = 0;
            for(int j=i; j<M; j++){
                sum += B[j];
                B_sum.add(sum);
            }
        }

        Collections.sort(A_sum);
        Collections.sort(B_sum);

        int L = 0, R = B_sum.size()-1;
        long ans = 0;

        while(L<A_sum.size() && R>=0){
            int sum = A_sum.get(L) + B_sum.get(R);
            if(sum == T){
                int valueA = A_sum.get(L);
                int valueB = B_sum.get(R);
                long aCnt = 0, bCnt = 0;
                while(L<A_sum.size() && valueA == A_sum.get(L)){
                    aCnt += 1;
                    L+=1;
                }
                while(R>=0 && valueB == B_sum.get(R)){
                    bCnt += 1;
                    R-=1;
                }
                ans += aCnt * bCnt;
            }else if(sum < T) L+=1;
            else R-=1;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
