package Programmers.level2.java;

import java.util.*;

class Solution {
    private Map<String, ArrayList<String>> clothMap = new HashMap();
    public int solution(String[][] clothes) {
        int answer = 1;
        ArrayList<String> list;
        for(String[] cloth : clothes){
            list = new ArrayList();
            if(clothMap.containsKey(cloth[1]))
                list = (ArrayList<String>)clothMap.get(cloth[1]).clone();
            list.add(cloth[0]);
            clothMap.put(cloth[1], list);
        }

        for(String key : clothMap.keySet()){
            answer *= clothMap.get(key).size()+1;
        }
        return answer-1;
    }
}