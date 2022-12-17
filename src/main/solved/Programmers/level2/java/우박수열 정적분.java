import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];

        double[] collatzArea = getCollatzArea(k);

        for (int i=0; i<ranges.length; i++) {
            int[] range = ranges[i];

            if (range[0] >= collatzArea.length || collatzArea.length + range[1] - 1 < 0) {
                answer[i] = -1.0;
                continue;
            }

            // 끝 영역 - 처음 이전 영역
            double rangeCalc = collatzArea[collatzArea.length - 1 + range[1]] - collatzArea[range[0]];
            answer[i] = rangeCalc >= 0 ? rangeCalc : -1.0;
        }

        return answer;
    }

    private double[] getCollatzArea(int k) {
        List<Integer> collatzList = new ArrayList();

        collatzList.add(k);
        while (k > 1) {
            if (k%2 ==0) {
                k /= 2;
            } else {
                k = k*3+1;
            }
            collatzList.add(k);
        }

        double[] collatzArea = new double[collatzList.size()];
        for (int i=1; i<collatzList.size(); i++) {
            collatzArea[i] = collatzArea[i-1] + ((double)collatzList.get(i)+collatzList.get(i-1))/2;
        }
        return collatzArea;
    }
}