package BOJ.p2100;

import java.io.*;
import java.util.*;

public class BOJ2109 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static Queue<int[]> queue = new PriorityQueue<>((n1, n2) -> (n1[0] == n2[0] ? n2[1]-n1[1] : n2[0] - n1[0]));
    static boolean[] check = new boolean[10001];

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            queue.add(new int[]{p, d});
        }
    }

    private static void process() throws IOException{
        int ans = 0;

        while(!queue.isEmpty()){
            int[] lecture = queue.poll();
            for(int j=lecture[1]; j>=1; j--){
                if(!check[j]){
                    check[j] = true;
                    ans += lecture[0];
                    break;
                }
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
