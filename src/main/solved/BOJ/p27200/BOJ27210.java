import java.io.*;
import java.util.*;

public class Main {

    private static int N;
    private static int[] dirs;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(Math.max(solve(1), solve(2)));
    }

    private static int solve(int d) {
        int res = 0, cnt = 0;
        for (int value : dirs) {
            cnt += value == d ? 1 : -1;
            cnt = Math.max(0, cnt);
            res = Math.max(res, cnt);
        }
        return res;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dirs = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dirs[i] = Integer.parseInt(st.nextToken());
        }
    }
}