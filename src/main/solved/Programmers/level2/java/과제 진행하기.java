// 스택을 이용해서 멈춘 과제들을 보관하고 Task 객체를 통해 관리합니다.
import java.util.*;

class Solution {

    public String[] solution(String[][] plans) {
        Task[] tasks = new Task[plans.length];
        for (int i=0; i<plans.length; i++) {
            int start = translateTimeToMin(plans[i][1]);
            int play = Integer.parseInt(plans[i][2]);

            tasks[i] = new Task(plans[i][0], start, play);
        }

        Arrays.sort(tasks);

        ArrayList<String> ansList = new ArrayList<>();
        Stack<Task> stack = new Stack<>();
        for (int i=0; i<tasks.length; i++) {

            // 현재 테스크의 끝나는 시간이 다음 테스크의 시작시간보다 빠를 경우
            if (i < tasks.length-1 && tasks[i].getFinishMin() > tasks[i+1].start) {
                // 진행된 시간만큼 차감하고 넣기.
                tasks[i].setRestPlay(tasks[i+1].start - tasks[i].start);
                stack.push(tasks[i]);
            } else {
                // 현재 테스크는 종료
                ansList.add(tasks[i].name);
                int curTime = tasks[i].getFinishMin();

                while (!stack.isEmpty()) {
                    Task rTask = stack.pop();

                    if (i == tasks.length-1) {
                        ansList.add(rTask.name);
                    }
                    else if (curTime == tasks[i+1].start) {
                        stack.push(rTask);
                        break;
                    }
                    else if (curTime+rTask.play <= tasks[i+1].start) {
                        curTime += rTask.play;
                        ansList.add(rTask.name);
                    }
                    else {
                        rTask.setRestPlay(tasks[i+1].start-curTime);
                        stack.push(rTask);
                        break;
                    }
                }
            }
        }

        String[] answer = new String[ansList.size()];
        for (int i=0; i<ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        return answer;
    }

    private int translateTimeToMin(String timeFormat) {
        String[] times = timeFormat.split(":");

        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);

        return hour*60+min;
    }


    class Task implements Comparable<Task>{
        private String name;
        private int start;
        private int play;

        public Task(String name, int start, int play) {
            this.name = name;
            this.start = start;
            this.play = play;
        }

        public void setRestPlay(int minus) {
            this.play -= minus;
        }

        public int getFinishMin() {
            return start+play;
        }

        @Override
        public int compareTo(Task t) {
            return this.start - t.start;
        }
    }
}