import java.util.*;

class Solution {
    public int solution(int[] ability, int number) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ab : ability) {
            pq.offer(ab);
        }

        for (int i=0; i<number; i++) {
            int sum = pq.poll() + pq.poll();
            pq.offer(sum);
            pq.offer(sum);
        }

        while (!pq.isEmpty()) {
            answer += pq.poll();
        }
        return answer;
    }
}