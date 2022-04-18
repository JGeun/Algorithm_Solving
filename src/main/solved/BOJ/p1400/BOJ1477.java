package BOJ.p1400;

import java.io.*;
import java.util.*;

public class BOJ1477 {
    private static int N, M, L;
    private static int[] rest;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        rest = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) rest[i] = Integer.parseInt(st.nextToken());
        rest[0] = 0;
        rest[N + 1] = L;

        Arrays.sort(rest);

        for (int i = 0; i <= N; i++) rest[i] = rest[i + 1] - rest[i] - 1;

        System.out.println(binary_search());
    }

    private static int binary_search() {
        int left = 1, right = L;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (restCnt(mid) <= M) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int restCnt(int res) {
        int cnt = 0;
        for (int i = 0; i <= N; i++)
            cnt += rest[i] / res;
        return cnt;
    }
}
