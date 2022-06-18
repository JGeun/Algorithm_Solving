class Solution {
    public int solution(int n) {
        int answer = 0;
        String ans = "";
        while(n > 0){
            ans += n%3;
            n /= 3;
        }
        int calc = 1;
        for(int i=ans.length(); i>=1; i--){
            answer += (calc*Integer.parseInt(ans.substring(i-1, i)));
            calc*=3;
        }
        return answer;
    }
}