package Programmers.level2;

import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;

        String[] nums = conversion(n, k).split("0");
        for(String num : nums){
            try{
                if(isPrime(Long.parseLong(num))) answer+=1;
            }catch(NumberFormatException e){
                continue;
            }
        }
        return answer;
    }
    public boolean isPrime(long num){
        if(num < 2) return false;

        for(int i=2; i<=Math.sqrt(num); i++){
            if(num%i==0) return false;
        }
        return true;
    }

    public String conversion(int n, int k){
        StringBuilder sb = new StringBuilder("");
        while(n!=0){
            sb.append(n%k);
            n /= k;
        }
        return sb.reverse().toString();
    }
}
