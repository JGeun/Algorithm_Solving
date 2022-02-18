package Programmers.level1;

import java.util.*;

//아스키코드 활용
public class Solution {
    public int solution(int n) {
        int answer = 0;
        for(char num : Integer.toString(n).toCharArray()) answer += num - '0';
        return answer;
    }
}

//Arrays.stream활용
public class Solution {
    public int solution(int n) {
        return Arrays.stream(Integer.toString(n).split("")).mapToInt(Integer::parseInt).sum();
    }
}
