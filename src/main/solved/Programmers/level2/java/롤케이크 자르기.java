import java.util.*;

class Solution {
    private HashMap<Integer, Integer> leftMap = new HashMap<>();
    private HashMap<Integer, Integer> rightMap = new HashMap<>();

    public int solution(int[] topping) {
        int answer = 0;

        for (int top : topping) {
            rightMap.put(top, rightMap.getOrDefault(top, 0) + 1);
        }

        for (int top : topping) {
            leftMap.put(top, leftMap.getOrDefault(top, 0) + 1);
            rightMap.put(top, rightMap.get(top) - 1);
            if (rightMap.get(top) == 0) rightMap.remove(top);

            if (leftMap.keySet().size() == rightMap.keySet().size()) {
                answer += 1;
            }
        }
        return answer;
    }
}