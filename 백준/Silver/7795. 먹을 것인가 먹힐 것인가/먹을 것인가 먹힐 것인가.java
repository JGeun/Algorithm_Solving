
import java.io.*;
import java.util.*;

/**
 * 1.B를 정렬
 * 2. A를 기준으로 반복하면서 B에서 이분탐색으로 해당 숫자보다 큰 수들 중 가장 작은 숫자를 찾고
 * 3. 해당 Index를 기준으로 B의 크기 - index + 1 로 sum에 더해주면 됨.
 */
class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;
    private static int T;
    private static int N, M;
    private static int[] A, B;
    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        while(T-->0) {
            init();
            solve();
        }
        System.out.print(sb.toString());
    }

    private static void solve() {
        Arrays.sort(B, 1, M+1);
        int ans = 0;
        for (int i=1; i<=N; i++) {
            ans += lower_bound(B, 1, M, A[i]);
        }
        sb.append(ans).append("\n");
    }

    private static int lower_bound(int[] arr, int L, int R, int X) {
         int res = L-1;
         while (L <= R) {
             int mid = (L+R) / 2;
             if (arr[mid] < X) {
                 res = mid;
                 L = mid + 1;
             } else {
                 R = mid - 1;
             }
         }

         return res;
    }

    private static void init() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N+1];
        B = new int[M+1];

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
    }
}
