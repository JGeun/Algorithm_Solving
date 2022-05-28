class Solution {
    public String solution(int n) {
        String[] store = {"4", "1", "2"};
        String answer="";

        while(n > 3) {
            int rest = n%3;
            answer = store[rest] + answer;
            if(rest == 0)
                n-=3;
            n /= 3;
        }
        answer = store[n%3]+ answer;
        return answer;
    }
}