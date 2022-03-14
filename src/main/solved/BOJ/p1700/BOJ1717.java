package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1717 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        for(int i=1; i<=N; i++) arr[i] = i;

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (type == 0) {
                unite(arr, a, b);
            } else {
                sb.append(compare(arr, a, b) ? "YES" : "NO").append('\n');
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int[] arr, int n){
        if(arr[n] == n) return n;
        return arr[n] = find(arr, arr[n]);
    }

    private static void unite(int[] arr, int x, int y){
        x = find(arr, x);
        y = find(arr, y);

        if(x != y){
            if(x < y) arr[y] = x;
            else arr[x] = y;
        }
    }

    private static boolean compare(int[] arr, int x, int y){
        return find(arr, x) == find(arr, y);
    }
}
