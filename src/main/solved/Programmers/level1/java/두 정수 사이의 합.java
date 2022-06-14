class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        int big = a>b? a : b;
        int small = a>b? b: a;
        for(int i=small; i<=big; i++)
            answer+=i;
        return answer;
    }
}