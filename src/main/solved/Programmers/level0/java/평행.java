import java.util.*;

class Solution {
    public int solution(int[][] dots) {

        Arrays.sort(dots, (n1, n2) -> {
            if (n1[0] != n2[0]) return n1[0] - n2[0];
            return n1[1] - n2[1];
        });

        double slope = (double)(dots[0][1] - dots[1][1])/(double)(dots[0][0] - dots[1][0]);
        double slope1 = (double)(dots[2][1] - dots[3][1])/(double)(dots[2][0] - dots[3][0]);

        if (slope == slope1) return 1;

        double slope2 = (double)(dots[0][1] - dots[2][1])/(double)(dots[0][0] - dots[2][0]);
        double slope3 = (double)(dots[1][1] - dots[3][1])/(double)(dots[1][0] - dots[3][0]);

        if (slope2 == slope3) return 1;

        double slope4 = (double)(dots[0][1] - dots[3][1])/(double)(dots[0][0] - dots[3][0]);
        double slope5 = (double)(dots[1][1] - dots[2][1])/(double)(dots[1][0] - dots[2][0]);

        if (slope4 == slope5) return 1;

        return 0;
    }
}