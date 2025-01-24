import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, S;
    static int[] A;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        A = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());
    }

    static void getMinLength(){
        int R=0, sum =0, ans = N+1;
        for(int L=1; L<=N; L++){
            sum -= A[L-1];

            while(R+1 <= N && sum < S){
                R += 1;
                sum += A[R];
            }

            if(sum >= S){
                ans = Math.min(ans, R - L + 1);
            }
        }

        if(ans == N+1){
            ans = 0;
        }
        System.out.println(ans);
    }
    public static void main(String[] args) throws IOException {
        input();
        getMinLength();
    }
}
