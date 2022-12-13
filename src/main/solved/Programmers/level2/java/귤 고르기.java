import java.util.*;

class Solution {
    private HashMap<Integer, Integer> cntMap = new HashMap();
    public int solution(int k, int[] tangerine) {
        int answer = 0;

        for(int tan : tangerine) {
            cntMap.put(tan, cntMap.getOrDefault(tan, 1) + 1);
        }

        List<Integer> keyList = new ArrayList<>(cntMap.keySet());
        keyList.sort((o1, o2) -> cntMap.get(o2) - cntMap.get(o2));

        for(int key : keyList) {
            k -= cntMap.get(key);
            answer += 1;

            if(k <= 0) break;
        }

        return answer;
    }
}