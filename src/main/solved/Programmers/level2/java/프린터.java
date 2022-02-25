package Programmers.level2.java;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        Queue<Doc> queue = new LinkedList<>();
        for(int i=0; i<priorities.length; i++){
            boolean isMine = false;
            if(i == location) isMine = true;
            queue.offer(new Doc(priorities[i], isMine));
        }

        PriorityQueue<Integer> priorityQueue = new PriorityQueue(Collections.reverseOrder());
        for(int priority : priorities)
            priorityQueue.add(priority);

        while(!queue.isEmpty()){
            Doc doc = queue.poll();
            if(doc.getPriority() == priorityQueue.peek()){
                if(doc.getIsMine()) return answer;
                answer +=1; priorityQueue.poll();
            }
            queue.offer(doc);
        }
        return answer;
    }
}

class Doc{
    private int priority;
    private boolean isMine;

    public Doc(int priority, boolean isMine){
        this.priority = priority;
        this.isMine = isMine;
    }

    public int getPriority(){
        return priority;
    }

    public boolean getIsMine(){
        return isMine;
    }
}
