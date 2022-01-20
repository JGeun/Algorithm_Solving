package BOJ.p1000;

import java.util.*;
import java.io.*;

public class BOJ1094 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int X;

    static void input() throws IOException {
        X = Integer.parseInt(br.readLine());
    }

    static void process() {
        int ans = 0;
        int stick = 64;

        while(X >0){
            if(stick > X) stick /= 2;
            else{
                ans+=1;
                X-=stick;
            }
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
