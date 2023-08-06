import java.io.*;
import java.util.*;

/**
 * 일단 이 문제에서 병이 모자랄 일은 없습니다. 계속 추가되기 때문입니다.
 * k개의 물병에 나눠 가진다고 해볼 때
 * 1. 주어진 물 n이 k보다 이하라면 그냥 다 들고 가면 됩니다.
 * 2. 주어진 물 n이 k보다 크다면 합쳐야 합니다.
 *
 * 2번의 과정에서 2^n 형태로 만드는 것이며 대부분 비트마스킹이 아닌 계속 제곱수를 빼는 형태로 접근했습니다.
 * ex) n = 13일 때 홀수이기 때문에 1개를 추가 구매하고 2로 나눈다 -> 7
 * n = 7일 때 홀수이기 때문에 1개를 추가 구매하고 2로 나눈다 -> 3
 * n = 3일 때 1, +1
 * 즉 3개를 더 사면 됩니다.
 *
 * if (n%2 == 1) {
 *    n = n/2
 *    cnt++
 *    n++
 * }
 *
 * n&(-n)을 사용하는 이유는 가장 오른쪽 비트1만 남기고 나머지 비트를 모두 0으로 만듭니다.
 * -> 보수를 만들 때 다 뒤집고 1을 더해주기 때문입니다.
 * 13 2
 * N: 14, ans = 1
 * N: 16, ans = 3
 */

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int k = input[1];
        int ans = 0;

        while (Integer.bitCount(n) > k) {
            ans += n & (-n);
            n += n & (-n);
        }
        System.out.println(ans);
    }
}