package BOJ.JGeun.p6500;

import java.io.*;
import java.util.*;

public class BOJ6588 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int MAX = 1000000;
    static boolean[] era = new boolean[MAX+1];

    static void setting() throws IOException {
        for(int i=2; i<=MAX; i++) if(isPrime(i)) era[i] = true;
    }

    static boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++) if(n%i==0) return false;
        return true;
    }

    static void process(int n){
        boolean isFind = false;
        for(int i=3; i<=n/2; i++){
            if(era[i] && era[n-i]){
                isFind = true;
                sb.append(n + " = " + i + " + " + (n-i)).append('\n');
                break;
            }
        }
        if(!isFind) sb.append("Goldbach's conjecture is wrong.").append('\n');
    }

    public static void main(String[] args) throws IOException {
        setting();
        while(true){
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;
            process(n);
        }
        System.out.print(sb);
    }
}
