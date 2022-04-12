package Programmers.level2.java;

import java.util.*;

class Solution {
    int[] answer = new int[11];
    int[] target = new int[11];
    int max = 0;
    public int[] solution(int n, int[] info) {

        int apache = getApache(info);
        makecase(n, info, 0, 0, 0, apache);
        if(max == 0) return new int[]{-1};
        return answer;
    }

    public void makecase(int n, int[] info, int pos, int cnt, int ryan, int apache){
        if(pos == 11){
            checkScore(n, cnt, ryan, apache);
            return ;
        }

        if(n >= cnt+info[pos]+1){
            target[pos] = info[pos]+1;
            if(info[pos] != 0)
                makecase(n, info, pos+1, cnt+target[pos], ryan+(10-pos), apache-(10-pos));
            else
                makecase(n, info, pos+1, cnt+target[pos], ryan+(10-pos), apache);
        }
        target[pos] = 0;
        makecase(n, info, pos+1, cnt,  ryan, apache);

    }

    public void checkScore(int n, int cnt, int ryan, int apache){
        if(n >= cnt && ryan >= apache){
            if(n>cnt) target[10] += n-cnt;
            if(isRyanWin(ryan, apache)){
                max = ryan-apache;
                answer = target.clone();
            }
        }
    }

    public boolean isRyanWin(int ryan, int apache){
        if(max < ryan-apache) return true;
        else if(max == ryan-apache){
            for(int i=10; i>=0; i--){
                if(target[i] > answer[i]){
                    return true;
                }else if(target[i] < answer[i]) break;
            }
        }
        return false;
    }

    public int getApache(int[] info){
        int sum = 0;
        for(int i=0; i<info.length; i++){
            if(info[i] != 0) sum+=(10-i);
        }
        return sum;
    }
}
