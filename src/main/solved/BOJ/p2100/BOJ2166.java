import java.io.*;
import java.util.*;

// 이 문제를 보고 무조건 공식이 있을 거라고 판단하였다.
// 신발끈 공식으로 풀면 해결되는 문제이지만 다만 범위가 long까지 도달할 수 있기에
// 조심해야한다.
class Main {

    private static int N;
    private static long[] x, y;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    private static void solve() {
        long sumA = 0L, sumB = 0L;

        for (int i=0; i<N; i++) {
            sumA += x[i] * y[i+1];
            sumB += x[i+1] * y[i];
        }

        String area = String.format("%.1f", (Math.abs(sumA - sumB) / 2.0));
        System.out.println(area);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        x = new long[N+1];
        y = new long[N+1];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        x[N] = x[0];
        y[N] = y[0];
    }
}