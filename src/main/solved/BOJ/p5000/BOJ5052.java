package BOJ.p5000;

import java.util.*;
import java.io.*;

public class BOJ5052 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static String[] arr;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for(int i=0; i<N; i++) arr[i] = br.readLine();
    }

    static void process() {
        Arrays.sort(arr);
        if(isConsistent()) sb.append("YES").append('\n');
        else sb.append("NO").append('\n');
    }
    static boolean isConsistent(){
        for(int i=0; i<N-1; i++){
            if(arr[i+1].startsWith(arr[i])) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            input();
            process();
        }
        System.out.print(sb);
    }
}
