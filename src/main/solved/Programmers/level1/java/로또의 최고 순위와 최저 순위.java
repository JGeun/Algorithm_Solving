import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] rank = {6, 6, 5, 4, 3, 2, 1};
        int zeroCnt = 0, correctCnt = 0;
        for(int i=0; i<lottos.length; i++){
            if(lottos[i] == 0) zeroCnt+=1;
            else if(findValue(win_nums, lottos[i])) correctCnt+=1;
        }
        return new int[]{rank[correctCnt+zeroCnt], rank[correctCnt]};
    }

    public boolean findValue(int[] win_nums, int lotto){
        for(int i=0; i<win_nums.length; i++) if(win_nums[i] == lotto) return true;
        return false;
    }
}