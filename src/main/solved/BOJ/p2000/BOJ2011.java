import java.io.*;
import java.util.*;

/*
 * (25114)
 * 2 -> 5 -> 1 -> 1 -> 4
 * 2 -> 5 -> 1 -> 14
 * 2 -> 5 -> 11 -> 4
 * 2 -> 51 -> 1 -> 4 X (앞 숫자와의 합이 10(J)~26(Z)만 가능)
 * 25 -> 1 -> 1 -> 4
 * 25 -> 1 -> 14
 * 25 -> 11 -> 4
 *
 * (101)
 * 1  -> 1 0 1 X (숫자가 0이면 패스해야함)
 * 1 0 -> 10 1 O
 * */

/*
 * "25114"
 * dp[0] = 1
 * dp[1] = 1 // 2: B
 * dp[2] = 2 // 2 5: BE, 25:Y
 * dp[3] = 2 // 2 5 1:BEA, 2 5 1 X, 25 1: YA
 * (1~9인 경우 dp[i] += dp[i-1], 하지만 51의 경우 안되므로 dp[i] += dp[i-2] X
 * dp[4] = 4 2 5 1 1: BEAA, 2 5 11: BEK, 25 1 1: YAA, 25 11: YK
 * (1~9인 경우 dp[i] += dp[i-1], 11 = 10~26이므로 dp[i] += dp[i-2]
 * dp[5] = 2 5 1 1 4: BEAAD, 2 5 11 4: BEKD, 2 5 1 14: BEAN,
 *                      25 1 1 4: YAAK, 25 11 4: YKD, 25 1 14: YAN,
 *
 */
public class Main {

    private static final int MOD = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] dp = new int[str.length()+1];
        dp[0] = 1;

        for(int i=1; i<=str.length(); i++) {
            int now = str.charAt(i-1) - '0';
            if(now >= 1 && now <= 9) {
                dp[i] += dp[i-1];
                dp[i] %= MOD;
            }

            if(i == 1) continue; //첫번째 글자일 경우

            int prev = str.charAt(i-2) - '0';

            if(prev == 0) continue; //0으로 시작할경우 존재 X

            int value = prev*10+now;

            if(value >= 10 && value <= 26) {
                dp[i] += dp[i-2];
                dp[i] %= MOD;
            }
        }
        System.out.println(dp[str.length()]);
    }
}