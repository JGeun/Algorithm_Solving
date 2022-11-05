import java.util.*;

class Solution {
    private int[] order;
    private boolean[] visit;
    private int ans = -1;
    public int solution(int k, int[][] dungeons) {
        order = new int[dungeons.length];
        Arrays.fill(order, -1);
        visit = new boolean[dungeons.length];
        makeCase(k, dungeons, 0);
        return ans;
    }

    public void makeCase(int k, int[][] dungeons, int cnt){
        if(cnt == order.length){
            checkCase(k, dungeons);
            return;
        }

        for(int i=0; i<order.length; i++){
            if(!visit[i]){
                visit[i] = true;
                order[cnt] = i;
                makeCase(k, dungeons, cnt+1);
                order[cnt] = -1;
                visit[i] = false;
            }
        }
    }

    public void checkCase(int k, int[][] dungeons){
        int cnt = 0;
        for(int i=0; i<order.length; i++){
            if(k < dungeons[order[i]][0]) break;
            k -= dungeons[order[i]][1];
            cnt+=1;
        }
        ans = Math.max(ans, cnt);
    }
}