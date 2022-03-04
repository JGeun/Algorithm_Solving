package BOJ.p1900;

import java.io.*;
import java.util.*;

public class BOJ1976 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] city;
    static String ans = "YES";
    static int[] order = new int[M];

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        city = new int[N+1];
        for(int i=1; i<=N; i++) city[i] = i;
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1; st.hasMoreTokens(); j++){
                if(st.nextToken().equals("1")){
                    unite(city, i, j);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        order = new int[M];
        for(int i=0; i<M; i++)
            order[i] = Integer.parseInt(st.nextToken());
    }

    private static void process() throws IOException{
        for(int i=0; i<M-1; i++){
            if(find(city, city[order[i]]) != find(city, city[order[i+1]])){
                ans = "NO"; break;
            }
        }
        System.out.println(ans);
    }

    private static int find(int[] city, int n){
        if(city[n] == n) return n;
        return find(city, city[n]);
    }

    private static void unite(int[] city, int x, int y){
        int a = find(city, x);
        int b = find(city, y);
        city[a] = b;
    }
    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}

