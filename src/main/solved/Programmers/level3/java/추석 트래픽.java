import java.util.*;

class Solution {
    private Time[] times;
    private PriorityQueue<Time> timePQ;
    public int solution(String[] lines) {
        int answer = 0;
        times = new Time[lines.length];
        for(int i=0; i<lines.length; i++){
            String[] line = lines[i].split(" ");
            double end = getTime(line[1]);
            double dif = 0.001;
            double start = end - Double.parseDouble(line[2].substring(0, line[2].length()-1)) + dif;
            times[i] = new Time(start, end);
        }

        Arrays.sort(times);
        timePQ = new PriorityQueue<>(new Comparator<Time>(){
            @Override
            public int compare(Time t1, Time t2){
                if(t1.end < t2.end) return -1;
                else if(t1.end > t2.end) return 1;
                else return 0;
            }
        });

        for(int i=0; i<times.length; i++){
            while(timePQ.size() != 0){
                if(timePQ.peek().end+1 <= times[i].start) timePQ.poll();
                else break;
            }
            timePQ.add(times[i]);
            answer = Math.max(answer, timePQ.size());
        }
        answer = Math.max(answer, timePQ.size());
        return answer;
    }

    public double getTime(String S){
        double sum = 0;
        String[] timeLine = S.split(":");
        int num = 3600;
        for(int i=0; i<timeLine.length; i++){
            sum += Double.parseDouble(timeLine[i]) * num;
            num /= 60;
        }
        return sum;
    }

    class Time implements Comparable<Time>{
        public double start, end;

        Time(double _start, double _end){
            this.start = _start;
            this.end = _end;
        }

        @Override
        public int compareTo(Time t){
            if(this.start < t.start) return -1;
            else if(this.start > t.start) return 1;
            else{
                if(this.end < t.end) return -1;
                else if(this.end > t.end) return 1;
                else return 0;
            }
        }
    }
}