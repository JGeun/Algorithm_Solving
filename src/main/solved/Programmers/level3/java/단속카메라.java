package Programmers.level3.java;

import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Arrays.sort(routes, (r1, r2) -> Integer.compare(r1[1], r2[1]));

        int start = 30000, end = -30001;
        for(int i=0; i<routes.length; i++){
            if(end < routes[i][0]){
                start = routes[i][0];
                end = routes[i][1];
                answer += 1;
            }else{
                start = Math.max(start, routes[i][0]);
                end = Math.min(end, routes[i][1]);
            }
        }
        return answer;
    }
}
