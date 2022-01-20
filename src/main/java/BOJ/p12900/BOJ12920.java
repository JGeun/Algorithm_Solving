package BOJ.p12900;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ12920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        int[] C = new int[N];
        int[] K = new int[N];
        int[] dp = new int[M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            V[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            K[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<int[]> thing = new ArrayList<>();

        for(int j = 0; j < N; j++) {
            for(int i = K[j]; i > 0; i>>=1) {
                int num = i-(i>>1);
                thing.add(new int[]{V[j]*num, C[j]*num});
            }
        }

        for(int i=0; i<thing.size(); i++){
            int[] pos = thing.get(i);
            int v = pos[0];
            int c = pos[1];
            for(int j = M; j >= v; j--) {
                dp[j] = Math.max(dp[j], dp[j-v]+c);
            }
        }

        System.out.println(dp[M]);
    }
}
