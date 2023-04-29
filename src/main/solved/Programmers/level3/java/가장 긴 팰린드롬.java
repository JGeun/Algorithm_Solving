import java.util.*;

class Solution{
    public int solution(String s){
        int answer = 0;

        for(int L=0; L<s.length(); L++){
            for(int R=L+1; R<=s.length(); R++){
                if(R-L > answer){
                    if(palind(s, L, R-1))
                        answer = Math.max(R-L, answer);
                }
            }
        }
        return answer;
    }

    public boolean palind(String str, int L, int R){
        while(L<R){
            if(str.charAt(L) != str.charAt(R))
                return false;
            L+=1; R-=1;
        }
        return true;
    }
}