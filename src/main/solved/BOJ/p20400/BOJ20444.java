import java.io.*;
import java.util.*;

// 9 -> (2+1)^2
// 8 -> (1+1) * (3+1)
// 17 -> 1 * 17
// 12 ? -> 1 * (11+1) / (1+1) * (1+5) / (2+1) * (3+1)
// 이 문제는 k의 약수를 구한 다음 (n-1 + 1) * (m-1 + 1) => n * m 을 (n-1)+(m-1)개 만큼 만들 수 있다는 문제입니다.
// 하지만 k가 어마어마하게 크기 때문에 n을 기준으로 이분탐색 해줘야함.
//
class Main {

    private static long n, k;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        long L = 0, R = n/2;

        while (L <= R) {
            long mid = (L+R)/2;

            long res = (mid+1) * (n-mid+1);
            if (res == k) {
                System.out.println("YES");
                return;
            } else if (res < k) {
                L = mid +1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println("NO");
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        k = Long.parseLong(st.nextToken());
    }
}