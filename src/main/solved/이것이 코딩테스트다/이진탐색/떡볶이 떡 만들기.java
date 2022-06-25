import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] lines = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            lines[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(lines);

        System.out.println(findMaxLine(lines));
    }

    private static int findMaxLine(int[] lines) {
        int start = lines[0], end = lines[lines.length-1], ans = start;

        while(start <= end) {
            int mid = (start+end)/2;
            if(determination(lines, mid)) {
                start = mid + 1;
                ans = mid;
            } else {
                end = mid - 1;
            }
        }
        return ans;
    }

    private static boolean determination(int[] lines, int mid) {
        int sum = 0;
        for(int i = 0; i < lines.length; i++) {
            if (lines[i] - mid > 0)
                sum += lines[i] - mid;
        }
        return sum >= M;
    }
}