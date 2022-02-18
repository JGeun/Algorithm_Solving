package Programmers.level1.java;

class Solution {
    public long solution(long n) {
        double num = Math.sqrt(n);
        if(num == (int)num)
            return (long)Math.pow((int)num+1 ,2);
        else
            return -1;
    }
}
