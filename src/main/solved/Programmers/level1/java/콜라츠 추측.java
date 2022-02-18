package Programmers.level1.java;

class Solution {
    public int solution(int num) {
        int answer = 0;
        long result = (long)num;
        while(answer <= 500){
            if(result == 1) return answer;
            result = (result%2==0) ? result/=2 : result*3+1;
            answer+=1;
        }
        return -1;
    }
}
