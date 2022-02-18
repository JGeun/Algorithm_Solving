package BOJ.p11600;

import java.io.*;
import java.util.*;

public class BOJ11659 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[] nums;
    static int[] next;
    static HashMap<Integer, Integer> hashMap = new HashMap<>();

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            nums[i] = nums[i-1]+Integer.parseInt(st.nextToken());
    }

    static void process() throws IOException{
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(nums[b] - nums[a-1]).append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
