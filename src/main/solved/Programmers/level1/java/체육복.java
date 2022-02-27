package Programmers.level1.java;

import java.util.*;

class Solution {
    // 5 -> 2 0 2 0 2
    // 5 -> 1 0 2 0 1
    // 3 -> 2 1 0
    public int solution(int n, int[] lost, int[] reserve) {
        int[] students = new int[n+1];
        Arrays.fill(students, 1);
        for(int l : lost) students[l] -= 1;
        for(int r : reserve) students[r] += 1;

        for(int i=1; i<=n; i++){
            if(students[i] == 2){
                if(i!=1 && students[i-1] == 0) students[i-1] += 1;
                else if(i!=n && students[i+1] == 0) students[i+1] += 1;
            }
        }

        int answer = n;
        for(int i=1; i<=n; i++)
            if(students[i] == 0) answer-=1;

        return answer;
    }
}
