import java.io.*;
import java.util.*;

public class Main {

    private static int N, K, ans = N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<K; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        findMaxNum(0);
        System.out.println(ans);
    }

    private static void findMaxNum(int num) {
        if(num > N) return;
        if(ans<num) ans = num;

        for(int i=K-1; i>=0; i--) {
            findMaxNum(num*10+arr[i]);
        }
    }
}