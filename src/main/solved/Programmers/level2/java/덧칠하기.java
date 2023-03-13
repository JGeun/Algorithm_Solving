import java.util.*;

class Solution {

    private HashSet<Integer> sectionSet = new HashSet<>();

    public int solution(int n, int m, int[] section) {
        int answer = 0;

        for (int s : section) {
            sectionSet.add(s);
        }

        for (int i=1; i<=n; i++) {
            if (!sectionSet.contains(i)) continue;
            answer += 1;
            i += m-1;
        }
        return answer;
    }
}