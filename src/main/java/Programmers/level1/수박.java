package Programmers.level1;

class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder("");
        for(int i=1; i<=n; i++)
            sb.append(i%2 == 0 ? '박' : '수');
        return sb.toString();
    }
}
