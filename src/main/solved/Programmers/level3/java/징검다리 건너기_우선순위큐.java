import java.util.*;

class Solution {
    private int max = 0;

    public int solution(int[] stones, int k) {

        PriorityQueue<Stone> pq = new PriorityQueue<>();

        int i;
        for (i=0; i<k; i++) {
            pq.add(new Stone(i, stones[i]));
        }

        int answer = pq.peek().val;

        while (i <stones.length) {
            pq.add(new Stone(i, stones[i]));
            i++;

            while (pq.peek().idx < i-k) {
                pq.poll();
            }

            answer = Math.min(answer, pq.peek().val);
        }


        return answer;
    }

    class Stone implements Comparable<Stone>{
        private int idx, val;

        public Stone(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Stone s) {
            return s.val - this.val;
        }
    }
}