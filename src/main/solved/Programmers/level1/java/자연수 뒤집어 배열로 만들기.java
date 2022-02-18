package Programmers.level1.java;

//기본 문제풀이
class Solution {
    public int[] solution(long n) {
        String[] nStr = Long.toString(n).split("");
        int[] answer = new int[nStr.length];
        for(int i=0; i<nStr.length; i++) answer[i] = Integer.parseInt(nStr[nStr.length-i-1]);
        return answer;
    }
}

//StringBuilder 이용 - 한줄해결
class Solution {
    public int[] solution(long n) {
        return new StringBuilder().append(n).reverse().chars().map(Character::getNumericValue).toArray();
    }
}