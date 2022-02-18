package BOJ.p1600;

import java.io.*;
import java.util.*;

public class BOJ1644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static boolean[] era;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        era = new boolean[N+1];
    }

    static void process(){
        for(int i=2; i<=N; i++){
            if(isPrime(i)) era[i] = true;
        }

        int ans =0, L = 2, R=L-1, sum=0;
        while(L <= N){
            while(R+1 <= N && sum+(R+1) <= N){
                R = R+1;
                if(!era[R]) continue;
                sum += R;
                if(sum == N) ans+=1;
                if(sum+(R+1) > N) break;
            }
            if(era[L]) sum -= L;
            L+=1;
        }
        System.out.println(ans);
    }

    static boolean isPrime(int num){
        for(int i=2; i<=Math.sqrt(num); i++)
            if(num%i == 0) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
