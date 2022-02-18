package Programmers.level1.java;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] words = s.split("");

        int index = -1;
        for(String word : words){
            index = word.contains(" ") ? -1 : index + 1;
            answer += index%2 == 0 ? word.toUpperCase() : word.toLowerCase();
        }
        return answer;
    }
}