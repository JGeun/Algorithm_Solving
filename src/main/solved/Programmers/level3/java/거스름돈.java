import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] dp = new int[n+1];

        int lastIdx = money.length-1;
        for (int i=money.length-1; i>=0; i--) {
            if (n < money[i]) {
                lastIdx = i;
                break;
            }
        }


        dp[0] = 1;
        for (int i=0; i<=lastIdx; i++) {
            for (int j=money[i]; j<=n; j++) {
                dp[j] += dp[j-money[i]];
            }
        }

        return dp[n];
    }
}