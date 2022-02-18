package Programmers.level1.java;

class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        String num = Integer.toString(x);
        int sum = 0;
        for(int i=0; i<num.length(); i++)
            sum += (num.charAt(i) -'0');

        if(x%sum != 0)
            answer =false;
        return answer;
    }
}
