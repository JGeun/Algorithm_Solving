package BOJ.p2200;

import java.io.*;
import java.util.*;

public class BOJ2212 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, K;
    static int[] nums;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            nums[i] = Integer.parseInt(st.nextToken());
    }

    static void process(){
        Arrays.sort(nums);

        ArrayList<Integer> range = new ArrayList<>();
        for(int i=0; i<N-1; i++)
            range.add(nums[i+1]-nums[i]);

        Collections.sort(range, Collections.reverseOrder());
        int sum = 0;
        for(int i=K-1; i<N-1; i++)
            sum += range.get(i);
        System.out.println(sum);
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }
}
