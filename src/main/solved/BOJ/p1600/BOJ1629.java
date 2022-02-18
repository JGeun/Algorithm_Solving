package BOJ.p1600;

import java.io.*;
import java.util.*;

public class BOJ1629 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int A, B, C;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
    }

    static long process(int b){
        if(b > 1){
            long value = process(b/2) % C;
            if(b%2 == 1) return value * value % C * A % C;
            return value* value%C;
        }
        return A%C;
    }

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(process(B));
    }
}
