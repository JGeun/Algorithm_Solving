package Programmers.level3.java;

import java.util.*;
class Solution {
    private boolean findAnswer = false;
    private String[] answer;
    private List<String> ansList = new ArrayList();
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, new Comparator<String[]>(){
            @Override
            public int compare(String[] s1, String[] s2){
                if(!s1[0].equals(s2[0])) return s1[0].compareTo(s2[0]);
                return s1[1].compareTo(s2[1]);
            }
        });
        ansList.add("ICN");
        findRoute(tickets, 0, new boolean[tickets.length]);

        return answer;
    }

    private void findRoute(String[][] tickets, int cnt, boolean[] visited){
        if(findAnswer) return;
        if(tickets.length == cnt){
            findAnswer = true;
            answer = new String[ansList.size()];
            for(int i=0; i<ansList.size(); i++) answer[i] = ansList.get(i);
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(tickets[i][0].equals(ansList.get(cnt)) && !visited[i]){
                ansList.add(tickets[i][1]); visited[i] = true;
                findRoute(tickets, cnt+1, visited);
                ansList.remove(cnt+1); visited[i] = false;
            }
        }
    }
}
