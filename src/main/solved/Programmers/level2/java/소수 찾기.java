package Programmers.level2.java;

import java.util.*;
class Solution {
    private Set<Integer> numSet = new HashSet();
    public int solution(String numbers) {
        char[] numArr = numbers.toCharArray();
        for(int i=1; i<=numArr.length; i++)
            makeCase(numArr, 0, i, new int[numArr.length], new boolean[numArr.length]);
        return numSet.size();
    }

    private void makeCase(char[] numArr, int cnt, int size, int[] idxArr, boolean[] visit){
        if(cnt == size){
            String numStr = "";
            for(int i=0; i<size; i++) numStr += numArr[idxArr[i]];
            int num = Integer.parseInt(numStr);
            if(isPrime(num)) numSet.add(num);
            return;
        }

        for(int i=0; i<numArr.length; i++){
            if(!visit[i]){
                visit[i] = true; idxArr[cnt] = i;
                makeCase(numArr, cnt+1, size, idxArr, visit);
                visit[i] = false;
            }
        }
    }

    private boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i<=Math.sqrt(n); i++)
            if(n%i==0) return false;
        return true;
    }
}
