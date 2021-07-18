package BOJ.JGeun.p2800;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
        int[] tree = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tree);

        long start = 1;
        long end = tree[N-1];
        while(start <= end){
            long total = 0;
            long mid = (start+end)/2;
            for(int i=0; i<tree.length; i++){
                if(tree[i] > mid)
                    total += (tree[i] - mid);
            }
            if(total < M)
                end = mid-1;
            else{
                start = mid+1;
            }
        }
        System.out.println(end);
    }
}
