package BOJ.JGeun.p2900;

import java.io.*;
import java.util.Arrays;

public class BOJ2981{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = 0;
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }
        Arrays.sort(arr);

    }
}
