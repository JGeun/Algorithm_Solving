import java.util.*;

class Solution {
    private ArrayList<ArrayList<Integer>> adj;
    private int[] dist;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];

        init(n, roads);
        solve(n, destination);

        for (int i=0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        return answer;
    }

    private void solve(int n, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[n+1];
        visited[start] = true;
        dist[start] = 0;

        while(!queue.isEmpty()) {
            int pos = queue.poll();

            for (int node : adj.get(pos)) {
                if (!visited[node]) {
                    visited[node] = true;
                    dist[node] = dist[pos]+1;
                    queue.offer(node);
                }
            }
        }
    }

    private void init(int n, int[][] roads) {
        dist = new int[n+1];
        Arrays.fill(dist, -1);

        adj = new ArrayList<>();
        for (int i=0; i<=n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] road : roads) {
            adj.get(road[0]).add(road[1]);
            adj.get(road[1]).add(road[0]);
        }
    }
}