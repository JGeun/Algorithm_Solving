class Solution {
    private int answer;
    public int solution(String s) {
        answer = s.length();

        for(int i=1; i<=s.length()/2; i++) {
            zipStr(s, i);
        }

        return answer;
    }

    private void zipStr(String s, int unit) {
        int cnt = 1, res = 0;
        String start = s.substring(0, unit);
        for(int i=unit; i<=s.length()-unit; i+=unit) {
            String slice = s.substring(i, i+unit);
            if(start.equals(slice)){
                cnt+=1;
            } else {
                res += calc(cnt, unit);
                cnt = 1;
                start = slice;
            }
        }
        res += calc(cnt, unit) + s.length()%unit;
        answer = Math.min(answer, res);
    }

    private int calc(int cnt, int unit) {
        if(cnt == 1) return unit;
        else return String.valueOf(cnt).length()+ unit;
    }
}