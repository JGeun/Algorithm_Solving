// 우선순위 큐를 통해 각각 거리별로 배달, 수거를 정리하고 둘 중 거리가 먼 것을 기준으로 왕복하면 되는 문제
import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        PriorityQueue<Item> deliveryPQ = new PriorityQueue<>();
        PriorityQueue<Item> pickupPQ = new PriorityQueue<>();

        long answer = 0;

        for (int i=0; i<n; i++) {
            if (deliveries[i] != 0) {
                deliveryPQ.offer(new Item(i+1, deliveries[i]));
            }
            if (pickups[i] != 0) {
                pickupPQ.offer(new Item(i+1, pickups[i]));
            }
        }

        while (!deliveryPQ.isEmpty() && !pickupPQ.isEmpty()) {
            int dDist = deliveryPQ.peek().dist;
            int pDist = pickupPQ.peek().dist;

            answer += dDist > pDist ? dDist*2 : pDist*2;

            int dCnt = 0;
            while (!deliveryPQ.isEmpty() && dCnt < cap) {
                Item dItem = deliveryPQ.poll();

                if (dCnt + dItem.cnt <= cap) {
                    dCnt += dItem.cnt;
                } else {
                    deliveryPQ.offer(new Item(dItem.dist, dItem.cnt+dCnt-cap));
                    dCnt = cap;
                }
            }

            int pCnt = 0;
            while (!pickupPQ.isEmpty() && pCnt < cap) {
                Item pItem = pickupPQ.poll();

                if (pCnt + pItem.cnt <= cap) {
                    pCnt += pItem.cnt;
                } else {
                    pickupPQ.offer(new Item(pItem.dist, pItem.cnt+pCnt-cap));
                    pCnt = cap;
                }
            }
        }

        while (!deliveryPQ.isEmpty()) {
            answer += deliveryPQ.peek().dist * 2;

            int dCnt = 0;
            while (!deliveryPQ.isEmpty() && dCnt < cap) {
                Item dItem = deliveryPQ.poll();

                if (dCnt + dItem.cnt <= cap) {
                    dCnt += dItem.cnt;
                } else {
                    deliveryPQ.offer(new Item(dItem.dist, dItem.cnt+dCnt-cap));
                    dCnt = cap;
                }
            }
        }

        while (!pickupPQ.isEmpty()) {
            int pCnt = 0;
            answer += pickupPQ.peek().dist * 2;
            while (!pickupPQ.isEmpty() && pCnt < cap) {
                Item pItem = pickupPQ.poll();

                if (pCnt + pItem.cnt <= cap) {
                    pCnt += pItem.cnt;
                } else {
                    pickupPQ.offer(new Item(pItem.dist, pItem.cnt+pCnt-cap));
                    pCnt = cap;
                }
            }
        }

        return answer;
    }

    class Item implements Comparable<Item>{
        private int dist, cnt;

        public Item(int dist, int cnt) {
            this.dist = dist;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Item i) {
            return i.dist - this.dist;
        }
    }
}