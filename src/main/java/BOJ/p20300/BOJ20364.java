package BOJ.p20300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20364 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, Q;
    static boolean[] map;
    static int[] duck;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        map = new boolean[N+1];
        duck = new int[Q];
        for(int i=0; i<Q; i++)
            duck[i] = Integer.parseInt(br.readLine());
    }

    static void process(){
        for(int i=0; i<Q; i++)
            findRoute(duck[i]);
        System.out.print(sb);
    }

    private static void findRoute(int num) {
        int idx = num;
        int ans = 0;
        while(idx != 0){
            if(map[idx])
                ans = idx;
            idx /=2;
        }
        sb.append(ans).append('\n');
        if(ans == 0) map[num] = true;
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
