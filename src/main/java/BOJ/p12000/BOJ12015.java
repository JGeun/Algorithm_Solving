package BOJ.p12000;

import java.io.*;
import java.util.*;

public class BOJ12015 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static int[] nums;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        nums = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) nums[i] = Integer.parseInt(st.nextToken());
    }

    static void process() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[1]);

        for(int i=2; i<=N; i++){
            int lower = lowerBound(list, 0, list.size(), nums[i]);
            if(list.size() <= lower) list.add(nums[i]);
            else list.set(lower, nums[i]);
        }
        System.out.println(list.size());
    }

    static int lowerBound(ArrayList<Integer> list, int left, int right, int key){
        while(left < right){
            int mid = (left+right)/2;
            if(list.get(mid) < key) left = mid+1;
            else right = mid;
        }
        return right;
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
