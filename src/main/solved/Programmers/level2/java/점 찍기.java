class Solution {
    public long solution(int k, int d) {
        long answer = 0;

        long d2 = (long)d*d;
        for (int x=0; x<=d; x+=k) {
            int y = (int)Math.sqrt(d2 - (long)x*x);
            answer += y/k+1;
        }

        return answer;
    }
}


