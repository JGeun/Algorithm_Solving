package Programmers.level2.java;

class Solution {
    public int gcd(int a, int b){
        if(a % b == 0) return b;
        return gcd(b, a%b);
    }
    public int gcm(int a, int b){
        return a > b ? a*b/gcd(a,b) : a*b/gcd(b,a);
    }
    public int solution(int[] arr) {
        int answer = 1;
        for(int num : arr) answer = gcm(answer, num);
        return answer;
    }
}
