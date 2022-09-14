import java.util.*;

class Solution {
    private Map<Character, Integer> typeMap = new HashMap();
    public String solution(String[] survey, int[] choices) {
        StringBuilder sb = new StringBuilder();
        int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
        char[] types = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};

        for (int i=0; i<types.length; i++)
            typeMap.put(types[i], 0);

        for (int i = 0; i < survey.length; i++) {
            int pos = 0;
            if (choices[i] >= 5) pos = 1;

            typeMap.put(survey[i].charAt(pos), typeMap.get(survey[i].charAt(pos))+score[choices[i]]);
        }

        for (int i=0; i<types.length; i+=2) {
            if (typeMap.get(types[i]) >= typeMap.get(types[i+1]))
                sb.append(types[i]);
            else
                sb.append(types[i+1]);
        }
        return sb.toString();
    }
}