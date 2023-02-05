import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] A, cnt;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        st= new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            A[i] = Integer.parseInt(st.nextToken());
        cnt = new int[100000 + 1];
    }

    static boolean func(int target_idx){
        int L=1, R=N;
        int target = A[target_idx];
        while(L < R){
            if(L == target_idx) L++;
            else if(R == target_idx) R--;
            else{
                if(A[L] + A[R] == target) return true;
                if(A[L] + A[R] > target) R--;
                else L++;
            }
        }
        return false;
    }

    static void process(){
        Arrays.sort(A, 1, N+1);

        int ans = 0;
        for(int i=1; i<=N; i++){
            if(func(i)) ans++;
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
