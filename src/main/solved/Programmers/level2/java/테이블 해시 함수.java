import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = -1;

        Arrays.sort(data, (d1, d2) -> {
            if (d1[col-1] != d2[col-1]) return d1[col-1] - d2[col-1];
            return d2[0] - d1[0];
        });

        for (int i=row_begin-1; i<=row_end-1; i++) {
            int sum = 0;
            for (int j=0; j<data[i].length; j++) {
                sum += data[i][j] % (i+1);
            }
            if (answer == -1) answer = sum;
            else answer = answer ^ sum;
        }

        return answer;
    }
}