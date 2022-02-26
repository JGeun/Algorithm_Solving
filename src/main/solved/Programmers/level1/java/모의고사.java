package Programmers.level1.java;

import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
                {1,2,3,4,5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        List<Integer> answerList = new ArrayList();
        int max = 0;

        for(int i=0; i<3; i++){
            int count = 0;
            for(int j=0; j<answers.length; j++){
                if(answers[j] == patterns[i][j%patterns[i].length]){
                    count += 1;
                }
            }
            if(count > max){
                answerList.clear();
                answerList.add(i+1);
                max = count;
            }else if(count == max){ answerList.add(i+1);}
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}