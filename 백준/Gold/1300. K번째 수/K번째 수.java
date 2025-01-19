
import java.io.*;
import java.util.*;

class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static int N, k;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        long L = 1, R = (long)N * N, ans = 0;

        while (L <= R) {
            long mid = (L + R) / 2;

            if (determine(mid, N, k)) {
                R = mid - 1;
                ans = mid;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean determine(long candidate, int N, int k) {
        long res = 0;
        for (int i=1; i<=N; i++) {
            res += Math.min(N, candidate/i);
        }
        return res >= k;
    }

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
    }
}
