import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (t1, t2) -> {
            return t1[1] - t2[1];
        });

        int last = Integer.MIN_VALUE;
        for (int[] target : targets) {
            if (last < target[0]) {
                answer+=1;
                last = target[1]-1;
            }
            System.out.println(last);
        }

        return answer;
    }
}