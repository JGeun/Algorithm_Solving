package Programmers.level2.java;

import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> scovPQ = new PriorityQueue<>();
        for(int sc : scoville) scovPQ.add(sc);

        while(scovPQ.size() >= 2){
            int shake = scovPQ.poll() + scovPQ.poll()*2;
            scovPQ.add(shake);
            answer+=1;
            if(scovPQ.peek() >= K) return answer;
        }
        return -1;
    }
}