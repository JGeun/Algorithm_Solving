package BOJ.JGeun.p1700;

import java.io.*;
import java.util.*;

public class BOJ1789 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static long N;

    static void input() throws IOException {
        N = Long.parseLong(br.readLine());
    }

    static void process(){
        long sum = 0;
        int ans = 0;
        for(int i=1; ;i++){
            if(sum>N) break;
            sum+=i;
            ans+=1;
        }
        System.out.println(ans-1);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
