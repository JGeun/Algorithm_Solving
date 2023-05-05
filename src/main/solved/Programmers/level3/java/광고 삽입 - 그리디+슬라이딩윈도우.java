// 1번 방법: 그리디로 모든 케이스를 숫자로 저장하고 반복문을 통해 찾는다.

class Solution {
    private int[] timeLine = new int[360000];
    public String solution(String play_time, String adv_time, String[] logs) {
        for (String log : logs) {
            String[] logTimes = log.split("-");
            int start = translateTimeToSec(logTimes[0]);
            int end = translateTimeToSec(logTimes[1]);

            for (int i=start; i<end; i++) {
                timeLine[i] += 1;
            }
        }

        int playTimeSec = translateTimeToSec(play_time);
        int advTimeSec = translateTimeToSec(adv_time);

        long res = 0;
        for (int i=0; i<advTimeSec; i++) {
            res += timeLine[i];
        }

        long maxRes = res;
        int startTimeSec = 0;
        for (int i=advTimeSec; i<playTimeSec; i++) {
            res += timeLine[i] - timeLine[i-advTimeSec];

            if (maxRes < res) {
                startTimeSec = i-advTimeSec+1;
                maxRes = res;
            }
        }

        return translateSecToTime(startTimeSec);
    }

    private String translateSecToTime(int sec) {
        int hour = sec/3600;
        String hourStr = hour < 10 ? "0"+hour : hour+"";
        sec %= 3600;
        int min = sec/60;
        String minStr = min < 10 ? "0"+min : min+"";
        sec %= 60;
        String secStr = sec < 10 ? "0"+sec : sec+"";
        return hourStr+":"+minStr+":"+secStr;
    }


    private int translateTimeToSec(String timeFormat) {
        String[] times = timeFormat.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2]);
        return hour * 3600 + min * 60 + sec;
    }
}