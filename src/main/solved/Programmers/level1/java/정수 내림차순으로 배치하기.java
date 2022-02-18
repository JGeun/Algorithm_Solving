package Programmers.level1.java;

import java.util.*;
import java.util.stream.*;

//Stream 활용
class Solution {
    public long solution(long n) {
        return Long.parseLong(Arrays.stream(String.valueOf(n).split("")).sorted(Comparator.reverseOrder())
                .collect(Collectors.joining()));
    }
}

//Collections.reverse활용
class Solution {
    public String reverseStr(String str){
        String[] array = str.split("");
        Arrays.sort(array);
        Collections.reverse(Arrays.asList(array));
        return String.join("", array);
    }
    public long solution(long n) {
        String s = Long.toString(n);
        Long answer = Long.parseLong(reverseStr(s));
        return answer;
    }
}
