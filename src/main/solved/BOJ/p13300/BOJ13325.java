package BOJ.p13300;

import java.io.*;
import java.util.*;

public class BOJ13325 {
    private static int K, size, ans = 0;
    private static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        K = Integer.parseInt(br.readLine());
        size = (int)Math.pow(2, K+1)-1;
        tree = new int[size+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=2; i<=size; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        find(1, 0); //root: 1, height: 0
        bw.write(ans+"\n");
        bw.flush(); bw.close(); br.close();
    }

    private static int find(int idx, int h) {
        if(h == K){
            ans += tree[idx];
            return tree[idx];
        }

        int left = find(idx*2, h+1);
        int right = find(idx*2+1, h+1);
        ans += tree[idx]+Math.abs(left-right);
        return tree[idx]+Math.max(left, right);
    }
}
