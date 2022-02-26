package Programmers.level2.java;

import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] nums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++)
            nums[i] = String.valueOf(numbers[i]);

        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s2+s1).compareTo(s1+s2);
            }
        });

        String answer = "";
        for(String num : nums) answer += num;
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}