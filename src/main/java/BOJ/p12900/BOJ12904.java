package BOJ.p12900;

import java.io.*;
import java.util.*;

public class BOJ12904 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static String S, T;

    static void input() throws IOException {
        S = br.readLine();
        T = br.readLine();
    }

    static int process(){
        StringBuilder sb = new StringBuilder(T);
        while(sb.length() != 0){
            char ch = sb.toString().charAt(sb.length()-1);
            sb.setLength(sb.length()-1);
            if(ch == 'B') sb=sb.reverse();
            if(sb.toString().equals(S)) return 1;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(process());
    }
}
