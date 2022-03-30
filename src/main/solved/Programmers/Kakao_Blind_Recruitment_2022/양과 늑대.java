package Programmers.Kakao_Blind_Recruitment_2022;

import java.util.ArrayList;

class Solution {
    private ArrayList<ArrayList<Integer>> edgeList = new ArrayList<>();
    private int answer = 0;
    public int solution(int[] info, int[][] edges) {
        for(int i=0; i<info.length; i++)
            edgeList.add(new ArrayList());
        for(int i=0; i<edges.length; i++)
            edgeList.get(edges[i][0]).add(edges[i][1]);

        ArrayList<Integer> restEdges = new ArrayList();
        restEdges.add(0);
        findSheep(info, restEdges, 0, 0);

        return answer;
    }

    private void findSheep(int[] info, ArrayList<Integer> restEdges, int sheep, int fox){
        if(answer != 0 && sheep <= fox) return;
        answer = Math.max(answer, sheep);

        for(int i=0; i<restEdges.size(); i++){
            ArrayList<Integer> tempEdges = (ArrayList<Integer>)restEdges.clone();
            int pos = tempEdges.remove(i);
            for(int j=0; j<edgeList.get(pos).size(); j++)
                tempEdges.add(edgeList.get(pos).get(j));

            if(info[pos] == 0) findSheep(info, tempEdges, sheep+1, fox);
            else findSheep(info, tempEdges, sheep, fox+1);
        }
    }
}
