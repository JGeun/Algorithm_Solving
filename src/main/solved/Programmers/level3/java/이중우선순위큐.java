package Programmers.level3.java;

import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        ArrayList<Integer> store = new ArrayList();
        PriorityQueue<Integer> maxQueue = new PriorityQueue(Collections.reverseOrder());
        PriorityQueue<Integer> minQueue = new PriorityQueue();

        for(String operation : operations){
            String[] ops = operation.split(" ");
            int num = Integer.parseInt(ops[1]);
            if(ops[0].equals("I")){
                maxQueue.add(num); minQueue.add(num);
                store.add(num);
            }else{
                if(num == -1)
                    maxQueue.remove(minQueue.poll());
                else
                    minQueue.remove(maxQueue.poll());
            }
        }

        answer[0] = maxQueue.isEmpty() ? 0 : maxQueue.peek();
        answer[1] = minQueue.isEmpty() ? 0 : minQueue.peek();
        return answer;
    }
}
