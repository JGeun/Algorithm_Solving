package Programmers.level3.java;

import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1, end = times[times.length-1]*(long)n;

        while(start <= end){
            long time = (start+end)/2;
            if(determine(n, times, time)){
                end = time-1;
                answer = time;
            }else{
                start=time+1;
            }
        }
        return answer;
    }

    private boolean determine(int n, int[] times, long time){
        long person = 0;
        for(int i=0; i<times.length; i++)
            person += time/times[i];
        return person >= n;
    }
}
