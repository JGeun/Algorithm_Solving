package Programmers.Kakao_Blind_Recruitment_2022;

import java.util.*;

class Solution {
    private int[] timeline = new int[360000];
    public String solution(String play_time, String adv_time, String[] logs) {
        for(int i=0; i<logs.length; i++){
            String[] timeInterval = logs[i].split("-");
            int start = getTime2Num(timeInterval[0]);
            int end = getTime2Num(timeInterval[1]);

            for(int j= start; j<end; j++) timeline[j]+=1;
        }

        int advTime = getTime2Num(adv_time);

        long value=0, maxValue=0;
        int startTime = 0;
        for(int i=0; i<advTime; i++) value += timeline[i];
        maxValue = value;

        for(int i=advTime; i<timeline.length; i++){
            value += timeline[i] - timeline[i-advTime];

            if(value > maxValue){
                maxValue = value;
                startTime = i-advTime+1;
            }
        }
        return getNum2Time(startTime);
    }

    private int getTime2Num(String time){
        String[] nums = time.split(":");
        return Integer.parseInt(nums[0]) * 3600 + Integer.parseInt(nums[1]) * 60 + Integer.parseInt(nums[2]);
    }

    private String getNum2Time(int num){
        String[] times = new String[3];
        times[0] = String.valueOf(num/3600);
        times[1] = String.valueOf(num%3600/60);
        times[2] = String.valueOf(num%60);
        for(int i=0; i<3; i++){
            while(times[i].length() < 2) times[i] = "0" + times[i];
        }
        return String.join(":", times);
    }
}