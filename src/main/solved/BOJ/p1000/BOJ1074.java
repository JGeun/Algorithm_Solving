package BOJ.p1000;

import java.io.*;
import java.util.*;

public class BOJ1074 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, r, c, ans = 0;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
    }

    static void process(int length, int r, int c){
        if(length == 2){
            if(r == 0 && c == 1) ans += 1;
            else if(r == 1 && c == 0) ans += 2;
            else if(r == 1 && c == 1) ans += 3;
            System.out.println(ans);
            return;
        }

        int cnt = 0, comR=0, comC=0;
        for(int i=0; i<2; i++){
            for(int j=0; j<2; j++){
                if(comR <= r && r < comR+length/2 && comC <= c && c < comC + length/2){
                    ans += cnt*(length/2)*(length/2);
                    r -= comR; c -= comC;
                    process(length / 2, r, c);
                    break;
                }
                comC += length/2;
                cnt += 1;
            }
            comR += length/2;
            comC = 0;
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        process((int)Math.pow(2,N), r, c);
    }
}
