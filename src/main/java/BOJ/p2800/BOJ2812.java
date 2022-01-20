package BOJ.p2800;

import java.io.*;
import java.util.*;

public class BOJ2812 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K;
    static String str;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        str = br.readLine();
    }

    static void process(){
        Stack<Integer> s = new Stack<>();
        int cnt = 0;
        for(int i=0; i<N; i++){
            int n = Integer.parseInt(str.substring(i,i+1));
            while(!s.empty() && cnt != K && s.peek() < n){
                s.pop();
                cnt+=1;
            }
            s.push(n);
        }
        while(cnt != K){
            s.pop();
            cnt+=1;
        }
        while(!s.isEmpty()) sb.append(s.pop());
        System.out.println(sb.reverse());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
