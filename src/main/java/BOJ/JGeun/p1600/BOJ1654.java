package BOJ.JGeun.p1600;

import java.io.*;
import java.util.*;

public class BOJ1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken()), N= Integer.parseInt(st.nextToken());
        int[] cable = new int[K];
        for(int i=0; i<K; i++)
            cable[i] = Integer.parseInt(br.readLine());

        Arrays.sort(cable);

        long start = 1;
        long end = cable[K-1];
        long result = 0;
        while(start <= end){
            long total = 0;
            long mid = (start+end)/2;
            for(int i=0; i<cable.length; i++){
                total += cable[i]/mid;
            }
            if(total < N)
                end = mid-1;
            else{
                result = mid;
                start = mid+1;
            }
        }
        System.out.println(result);
    }
}
