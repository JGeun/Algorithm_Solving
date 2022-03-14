package BOJ.p20000;

import java.io.*;
import java.util.*;

public class BOJ20040 {
    private static int ans = 1;
    private static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N];
        for(int i=0; i<N; i++) parent[i] = i;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(find(a) != find(b)){
                unite(a, b); ans+=1;
            }else{
                System.out.println(ans);
                return;
            }
        }
        System.out.println(0);
    }

    private static int find(int n){
        if(parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }

    private static void unite(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }
}
