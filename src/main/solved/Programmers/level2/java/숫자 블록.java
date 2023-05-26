import java.util.*;

class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)(end-begin+1)];

        int idx = 0;
        for (int i=(int)begin; i<=(int)end; i++) {
            boolean isPrime = true;
            if (i == 1) {
                answer[idx++] = 0;
                continue;
            }

            for (int j=2; j*j<=i; j++) {
                if (i%j == 0 && i / j <= 1000000) {
                    answer[idx++] = i/j;
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                answer[idx++] = 1;
            }
        }
        return answer;
    }
}