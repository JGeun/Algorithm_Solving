import java.io.*;
import java.util.*;

class Main {

    private static int N, M, start, end;
    private static ArrayList<ArrayList<Route>> routes = new ArrayList<>();
    private static int[] dist;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Route> pq = new PriorityQueue<>();
        dist[start] = 0;
        List<Integer> cityList = new ArrayList<>();
        cityList.add(start);
        pq.offer(new Route(start, start,0, cityList));

        while(!pq.isEmpty()) {
            Route curRoute = pq.poll();
            if (visited[curRoute.now]) continue;
            visited[curRoute.now] = true;

            if (curRoute.now == end) {
                sb.append(curRoute.cost).append('\n');
                sb.append(curRoute.cityList.size()).append('\n');
                for (int i=0; i<curRoute.cityList.size(); i++) {
                    sb.append(curRoute.cityList.get(i));
                    if (i != curRoute.cityList.size()-1) sb.append(' ');
                }
                break;
            }

            for (Route nextRoute : routes.get(curRoute.now)) {
                curRoute.cityList.add(nextRoute.now);
                pq.offer(new Route(curRoute.now, nextRoute.now, curRoute.cost + nextRoute.cost, curRoute.cityList));
                curRoute.cityList.remove(Integer.valueOf(nextRoute.now));
            }
        }

        System.out.print(sb);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        visited = new boolean[N+1];

        for (int i=0; i<=N; i++) {
            routes.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            routes.get(S).add(new Route(S, E, cost));
        }

        for (int i=0; i<=N; i++) {
            Collections.sort(routes.get(i));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
    }

    static class Route implements Comparable<Route>{
        int prev, now, cost;
        List<Integer> cityList;

        public Route(int prev, int now, int cost) {
            this.prev = prev; this.now = now; this.cost = cost;
            cityList = new ArrayList<>();
        }

        public Route(int prev, int now, int cost, List<Integer> cityList) {
            this.prev = prev; this.now = now; this.cost = cost;
            this.cityList = new ArrayList<>();
            this.cityList.addAll(cityList);
        }

        @Override
        public int compareTo(Route r) {
            if (this.cost != r.cost) return this.cost - r.cost;
            if (this.prev != r.prev) return this.prev - r.prev;
            return this.now - r.now;
        }
    }
}