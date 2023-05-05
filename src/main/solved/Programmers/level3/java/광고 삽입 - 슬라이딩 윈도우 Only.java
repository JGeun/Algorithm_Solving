import java.util.*;

class Solution {
    private int[] timeLine = new int[360000];

    public String solution(String play_time, String adv_time, String[] logs) {

        // 비디오 객체 초기화
        Video[] videos = new Video[logs.length];

        for (int i=0; i<logs.length; i++) {
            String[] logTimes = logs[i].split("-");
            int start = translateTimeToSec(logTimes[0]);
            int end = translateTimeToSec(logTimes[1]);
            videos[i] = new Video(start, end);
        }
        Arrays.sort(videos);


        // 처리 과정
        int playTime = translateTimeToSec(play_time);
        int advTime = translateTimeToSec(adv_time);
        PriorityQueue<Integer> endPQ = new PriorityQueue<>();

        int videoIdx = 0;
        for (int i=0; i<playTime; i++) {

            while (videoIdx < videos.length && i == videos[videoIdx].start) {
                endPQ.offer(videos[videoIdx].end);
                videoIdx += 1;
            }
            timeLine[i] += endPQ.size();

            while (!endPQ.isEmpty()) {
                if (endPQ.peek() != i) break;

                timeLine[i] -= 1;
                endPQ.poll();
            }
        }

        long res = 0;
        for (int i=0; i<advTime; i++) {
            res += timeLine[i];
        }

        long maxRes = res;
        int startTime = 0;
        for (int i=advTime; i<playTime; i++) {
            res += timeLine[i] - timeLine[i-advTime];

            if (maxRes < res) {
                startTime = i-advTime+1;
                maxRes = res;
            }
        }

        return translateSecToTime(startTime);
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

    class Video implements Comparable<Video> {
        private int start, end;

        public Video(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Video v) {
            if (this.start != v.start) return this.start - v.start;
            return this.end - v.end;
        }
    }
}