package Programmers.Kakao_Blind_Recruitment_2022;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Solution {
    private HashSet<String> reportSet = new HashSet();
    public int[] solution(String[] id_list, String[] report, int k) {
        List<String> idList = Arrays.asList(id_list);
        int[] answer = new int[id_list.length];
        int[] userReportedCnt  = new int[id_list.length];

        for(String r : report) reportSet.add(r);
        for(String r : reportSet){
            String[] reportContents = r.split(" ");
            userReportedCnt[idList.indexOf(reportContents[1])] +=1;
        }
        for(String r : reportSet){
            String[] reportContents = r.split(" ");
            if(userReportedCnt[idList.indexOf(reportContents[1])] >= k){
                answer[idList.indexOf(reportContents[0])] +=1;
            }
        }
        return answer;
    }
}
