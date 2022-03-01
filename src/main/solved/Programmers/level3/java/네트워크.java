package Programmers.level3.java;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visit[i]){
                visit[i] = true;
                connectNetwork(computers, visit, i);
                answer+=1;
            }
        }
        return answer;
    }

    private void connectNetwork(int[][] computers, boolean[] visit, int start){
        for(int i=0; i<computers[start].length; i++){
            if(computers[start][i] == 1 && !visit[i]){
                visit[i] = true;
                connectNetwork(computers, visit, i);
            }
        }
    }
}
