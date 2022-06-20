import java.util.*;
import java.io.*;

public class Main {
    private static int N, M;
    private static int[] mins;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        mins = new int[N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < M; j++) {
                min = Math.min(min, Integer.parseInt(st.nextToken()));
            }
            mins[i] = min;
        }
        Arrays.sort(mins);
        System.out.println(mins[mins.length-1]);
    }
}