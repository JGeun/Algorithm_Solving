import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 0;

        int[] wanHo = scores[0];
        Arrays.sort(scores, (s1, s2) ->
                s1[0] == s2[0] ? s1[1] - s2[1] : s2[0] - s1[0]);
        ArrayList<Integer> ranking = new ArrayList<>();

        int maxScore = 0;
        for (int[] score : scores) {

            if (score[1] < maxScore) {
                if (score.equals(wanHo)) {
                    return -1;
                }
            } else {
                // 인센대상
                ranking.add(score[0] + score[1]);
                maxScore = Math.max(maxScore, score[1]);
            }
        }

        ranking.add(200001);
        ranking.sort((a, b) -> b - a);

        return ranking.indexOf(wanHo[0]+wanHo[1]);
    }
}