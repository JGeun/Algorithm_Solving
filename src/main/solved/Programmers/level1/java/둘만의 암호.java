import java.util.*;

class Solution {
    private HashSet<Character> skipSet = new HashSet<>();

    public String solution(String s, String skip, int index) {
        String answer = "";

        for (char skipChr : skip.toCharArray()) {
            skipSet.add(skipChr);
        }

        for (int i=0; i<s.length(); i++) {
            answer += getAlpha(s.charAt(i), index);
        }

        return answer;
    }

    private char getAlpha(char ch, int index) {

        int i = 0;
        char alpha = ch;
        while (i < index) {
            alpha = (char)(alpha+1);
            if (alpha > 'z') alpha = 'a';
            if (skipSet.contains(alpha)) continue;
            i += 1;
        }
        return alpha;
    }
}