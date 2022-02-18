package Programmers.level1.java;

class Solution {
    public String solution(String phone_number) {
        String answer = "";
        for(int i=0; i<phone_number.length()-4; i++)
            answer = answer.concat("*");
        answer = answer.concat(phone_number.substring(phone_number.length()-4, phone_number.length()));
        return answer;
    }
}
