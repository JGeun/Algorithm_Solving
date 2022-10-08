import java.util.*;

class Solution {
    private Map<String, Integer> wantMap = new HashMap<>();

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int totalCnt = getTotalCnt(number);
        fillFirstCondition(totalCnt, discount);

        if (compareWantCondition(want, number)) answer += 1;
        for (int i=totalCnt; i<discount.length; i++) {
            String frontItem = discount[i-totalCnt];
            wantMap.put(frontItem, wantMap.get(frontItem)-1);
            putHashMap(discount[i]);
            if (compareWantCondition(want, number)) answer += 1;
        }

        return answer;
    }

    private boolean compareWantCondition(String[] want, int[] number) {
        for (int i=0; i<want.length; i++) {
            if (!wantMap.containsKey(want[i])) return false;
            if (number[i] != wantMap.get(want[i])) return false;
        }
        return true;
    }

    private int getTotalCnt(int[] number) {
        int totalCnt = 0;
        for (int i=0; i<number.length; i++)
            totalCnt += number[i];
        return totalCnt;
    }

    private void fillFirstCondition(int totalCnt, String[] discount) {
        for (int i=0; i<totalCnt; i++) {
            putHashMap(discount[i]);
        }
    }

    private void putHashMap(String discount) {
        if (wantMap.containsKey(discount)) {
            wantMap.put(discount, wantMap.get(discount) + 1);
        } else {
            wantMap.put(discount, 1);
        }
    }
}