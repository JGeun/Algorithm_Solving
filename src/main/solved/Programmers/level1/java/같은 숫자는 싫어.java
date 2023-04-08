import java.util.*;

public class Solution {
    public int[] solution(int []arr) {

        ArrayList<Integer> list = new ArrayList<Integer>();
        int exNum = -1;
        for(int i=0; i<arr.length; i++){
            if(exNum != arr[i]){
                list.add(arr[i]);
                exNum = arr[i];
            }
        }
        int[] answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i).intValue();
        }

        return answer;
    }
}