package BOJ.JGeun.p16900;

import java.io.*;
import java.util.*;

public class BOJ16953 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static long A, B;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
    }

    static int process(){
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(A, 0));
        while(!queue.isEmpty()){
            Pair num = queue.poll();
            if(num.n == B) return num.cnt+1;
            long x = num.n*2;
            if(x <= B) queue.add(new Pair(x, num.cnt+1));
            x = num.n*10+1;
            if(x <= B) queue.add(new Pair(x, num.cnt+1));
        }
        return -1;
    }

    public static void main(String[] args) throws IOException{
        input();
        System.out.println(process());
    }

    static class Pair{
        long n;
        int cnt;

        public Pair(long _n, int _cnt){
            this.n = _n; this.cnt = _cnt;
        }
    }
}
