package BOJ.p3000;

import java.io.*;
import java.util.*;

public class BOJ3020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, H;
    static int[] bot, top, bot_sum, top_sum;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bot = new int[H+1];
        top = new int[H+1];
        for(int i=1; i<=N/2; i++){
            bot[Integer.parseInt(br.readLine())] += 1;
            top[Integer.parseInt(br.readLine())] += 1;
        }
    }

    static void process() {
        bot_sum = new int[H+1];
        top_sum = new int[H+1];
        for(int i=1; i<=H; i++){
            top_sum[i] = top_sum[i-1] + top[i];
            bot_sum[i] = bot_sum[i-1] + bot[i];
        }

        int ans = N, cnt = 0;
        for(int i=1; i<=H; i++){
            int crash = 0;

            crash += bot_sum[H] - bot_sum[H-i];
            crash += top_sum[H] - top_sum[i-1];

            if(ans > crash){
                ans = crash;
                cnt = 1;
            }else if(ans == crash) cnt+=1;
        }

        System.out.println(ans + " " + cnt);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
