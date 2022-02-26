package Programmers.level2.java;

import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int answer = 0;
        for(int i = citations.length-1; i >= 0; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            answer = Math.max(answer, min);
        }

        return answer;
    }
}
