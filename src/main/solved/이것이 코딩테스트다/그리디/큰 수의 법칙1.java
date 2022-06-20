import java.util.*;
import java.io.*;

public class Main {
    private static int N, M, K;
    private static int[] arr;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int first = arr[arr.length-1];
        int second = arr[arr.length-2];

        int cnt = 0, sum = 0;
        for(int i = 0; i < M; i++) {
            if(cnt != K) {
                sum += first;
                cnt += 1;
            } else {
                cnt = 0;
                sum += second;
            }
        }
        System.out.println(sum);
    }
}