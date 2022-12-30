import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[][] info;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        info = new int[N+1][3];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++)
                info[i][j] = Integer.parseInt(st.nextToken());
        }
    }

    static int count(int A, int C, int B, int X){
        if(X < A) return 0;
        if(C < X) return (C-A)/B+1;
        return (X-A)/B+1;
    }

    static boolean determination(int candidate){
        long sum = 0;
        for(int i=1; i<=N; i++)
            sum += count(info[i][0], info[i][1], info[i][2], candidate);
        return sum%2==1;
    }

    static void process() {
        long L=1, R=Integer.MAX_VALUE, ans=0, ansCnt=0;

        while(L <= R){
            long mid = (L+R)/2;
            if(determination((int)mid)){
                ans = mid;
                R = mid-1;
            }else{
                L = mid+1;
            }
        }

        if(ans == 0)
            System.out.println("NOTHING");
        else{
            for(int i=1; i<=N; i++){
                if(info[i][0] <= ans && ans <= info[i][1] && (ans - info[i][0]) % info[i][2] == 0){
                    ansCnt++;
                }
            }
            System.out.println(ans + " " + ansCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}