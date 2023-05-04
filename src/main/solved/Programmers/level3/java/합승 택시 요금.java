// 이 문제는 S를 기준으로 다익스트라를 적용하고 해당 위치에서 각각 B, A가 자기 위치까지 찾아가는 다익스트라를 적용해서 최솟값을 찾는 문제

import java.util.*;

class Solution {
    private ArrayList<ArrayList<Node>> adj = new ArrayList<>();
    private final int INF = 20000001;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] fare : fares) {
            adj.get(fare[0]).add(new Node(fare[1], fare[2]));
            adj.get(fare[1]).add(new Node(fare[0], fare[2]));
        }

        int[] distS = dijkstra(n, s);
        int[] distA = dijkstra(n, a);
        int[] distB = dijkstra(n, b);

        int min = Integer.MAX_VALUE;
        for (int i=1; i<=n; i++) {
            if (min > distS[i] + distA[i] + distB[i]) {
                min = distS[i] + distA[i] + distB[i];
            }
        }

        return min;
    }

    private int[] dijkstra(int n, int s) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[s] = 0;
        pq.offer(new Node(s, dist[s]));

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if (node.d > dist[node.idx]) continue;
            for (Node next : adj.get(node.idx)) {
                if (next.d + dist[node.idx]  > dist[next.idx]) continue;
                dist[next.idx] = dist[node.idx] + next.d;
                pq.offer(new Node(next.idx, dist[next.idx]));
            }
        }

        return dist;
    }

    class Node implements Comparable<Node>{
        private int idx, d;

        public Node(int idx, int d) {
            this.idx = idx; this.d = d;
        }

        @Override
        public int compareTo(Node n) {
            return this.d - n.d;
        }
    }
}