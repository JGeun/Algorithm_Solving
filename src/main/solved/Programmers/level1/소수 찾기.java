package Programmers.level1;

class Solution {
    public int solution(int n) {
        int count = 0;
        for(int i=2; i<=n; i++)
            if(isPrime(i)) count+=1;
        return count;
    }

    public boolean isPrime(int n){
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i ==0) return false;
        return true;
    }
}