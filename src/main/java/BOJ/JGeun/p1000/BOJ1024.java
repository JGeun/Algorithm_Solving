package BOJ.JGeun.p1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1024 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, L;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
    }

    static void process(){
        for(int i=L; i<=100; i++){
            int num = N/i, side = (i-1)/2;
            if(num - side < 0) break;

            long sum = 0;
            for(int j = num-side; j<=num+side; j++) sum += j;
            if(i%2==0) sum+=num+side+1;

            if(sum == N){
                for(int j = num-side; j<=num+side; j++) sb.append(j+ " ");
                if(i%2==0) sb.append(num+side+1 + " ");
                System.out.println(sb);
                return;
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
