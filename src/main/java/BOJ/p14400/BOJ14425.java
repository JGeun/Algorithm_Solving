package BOJ.p14400;

import java.io.*;
import java.util.*;

public class BOJ14425 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static HashMap<String, Integer> map = new HashMap<>();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for(int i=0; i<N; i++) map.put(br.readLine(), 1);
    }

    static void process() throws IOException{
        int ans = 0;
        for(int i=0; i<M; i++){
            if(map.get(br.readLine()) != null) ans+=1;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
