package Programmers.level2.java;

import java.util.*;

class Solution {
    HashMap<String, ArrayList<String>> cars = new HashMap();
    List<String> carNums = new ArrayList();
    ArrayList<String> times;
    public int[] solution(int[] fees, String[] records){
        for(String record : records){
            String[] contents = record.split(" ");
            if(!cars.containsKey(contents[1])){
                carNums.add(contents[1]);
                times = new ArrayList();
            }
            else times = cars.get(contents[1]);

            times.add(contents[0]);
            cars.put(contents[1], times);
        }

        int[] answer = new int[cars.size()];
        Collections.sort(carNums);
        int i = 0;
        for(String key : cars.keySet()){
            times = cars.get(key);
            int timeSum = 0;
            for(int j=0; j<times.size(); j++){
                String start = times.get(j);
                String end = "";
                if(j<times.size()-1){
                    end = times.get(j+1);
                    j+=1;
                }
                else end = "23:59";
                timeSum += getTime(end) - getTime(start);
            }

            answer[carNums.indexOf(key)] += getCalcFee(timeSum, fees);
        }
        return answer;
    }

    public int getCalcFee(int time, int[] fees){
        if(time <= fees[0]) return fees[1];
        return fees[1] + (int)Math.ceil((double)(time-fees[0])/fees[2])*fees[3];
    }

    public int getTime(String time){
        String[] t = time.split(":");
        return Integer.parseInt(t[0])*60+Integer.parseInt(t[1]);
    }
}

