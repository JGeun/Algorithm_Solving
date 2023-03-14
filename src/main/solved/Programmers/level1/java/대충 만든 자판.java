import java.util.*;

class Solution {
    private HashMap<Character, Integer> keyMinCntMap = new HashMap<>();

    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];

        for (int i=0; i<keymap.length; i++) {
            int cnt = 0;
            for (int j=0; j<keymap[i].length(); j++) {
                char key = keymap[i].charAt(j);
                int keyMin = keyMinCntMap.getOrDefault(key, 101);
                keyMinCntMap.put(key, Math.min(keyMin, j+1));
            }
        }

        for (int i=0; i<targets.length; i++) {

            int sum = 0;
            boolean isNotFound = false;
            for (int j=0; j<targets[i].length(); j++) {
                char ch = targets[i].charAt(j);

                if (!keyMinCntMap.containsKey(ch)) {
                    isNotFound = true;
                    break;
                }

                sum += keyMinCntMap.get(ch);
            }
            answer[i] = isNotFound ? -1 : sum;
        }
        return answer;
    }
}