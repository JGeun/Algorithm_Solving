import java.io.*;
import java.util.*;

class Main {

    private static int N, K;
    private static double[] arr;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        double sum = 0.0f;
        for (int i=K; i<N-K; i++) {
            sum += arr[i];
        }

        double res1 = sum/(N-2*K) + 1e-8;
        sb.append(String.format("%.2f", res1)).append('\n');

        double sum2 = 0.0f;
        sum2 += K * arr[K];
        sum2 += K * arr[N-K-1];
        sum2 += sum;

        double res2 = sum2/N  + 1e-8;
        sb.append(String.format("%.2f", res2)).append('\n');

        System.out.print(sb.toString());
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new double[N];
        for (int i=0; i<N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        Arrays.sort(arr);
    }
}