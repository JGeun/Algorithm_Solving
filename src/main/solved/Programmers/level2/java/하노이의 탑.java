import java.util.*;

class Solution {
    private ArrayList<int[]> hanoiCase = new ArrayList();

    public int[][] solution(int n) {
        getHanoi(1, 2, 3, n);
        int[][] answer = new int[hanoiCase.size()][2];
        for(int i=0; i<hanoiCase.size(); i++) answer[i] = hanoiCase.get(i);
        return answer;
    }

    public void getHanoi(int from, int temp, int to, int n){
        if(n == 0)
            return;

        getHanoi(from, to, temp, n-1);
        hanoiCase.add(new int[]{from, to});
        getHanoi(temp, from, to, n-1);
    }
}