package Programmers.level2.java;

import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder(number);
        int idx = 0;

        while(idx < sb.length()-1 && k != 0) {
            idx ++;

            if(sb.charAt(idx-1) < sb.charAt(idx)){
                sb.deleteCharAt(idx-1);
                idx = 0;
                k--;
            }
        }

        if(k != 0){
            for(int i=0; i<k; i++)
                sb.deleteCharAt(sb.length()-1);
        }
        return sb.toString();
    }
}

class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for(int i=0; i<number.length() - k; i++) {
            int max = 0;
            for(int j = index; j<= k+i; j++) {
                if(max < number.charAt(j)-'0') {
                    max = number.charAt(j)-'0';
                    index = j+1;
                }
            }
            sb.append(max);
        }
        return sb.toString();
    }
}