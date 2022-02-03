package Programmers.level1;

class Solution {
    public int[] solution(int n, int m) {
        int gcd = n<m? getGCM(n,m) : getGCM(m,n);
        return new int[]{gcd, n*m/gcd};
    }

    public int getGCM(int a, int b){
        while(a != 0){
            int temp = b%a;
            b = a;
            a = temp;
        }
        return b;
    }
}