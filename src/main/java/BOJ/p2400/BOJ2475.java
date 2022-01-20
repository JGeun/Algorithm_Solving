package BOJ.p2400;

import java.io.*;
import java.util.*;

public class BOJ2475 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int[] nums;

    static void input() throws IOException {
        nums = new int[5];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<5; i++) nums[i] = Integer.parseInt(st.nextToken());
    }

    static void process(){
        int sum = 0;
        for(int num : nums) sum += (int)Math.pow(num,2);
        System.out.println(sum%10);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
