import java.io.*;
import java.util.*;

// 1. 각 섬의 다리 중 제일 값이 큰걸로 처리
// 2. 우선순위 큐를 이용해 중량의 최댓값을 가져가도록 처리 - 이 부분은 메모리초과
// 3. 이분탐색으로 중량을 제한하고 탐색

class Main {

    private static int N, M, S, E;
    private static ArrayList<ArrayList<Island>> adj;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() throws IOException {
        int L = 1, R = 1000000000, ans = L;

        while (L <= R) {
            int mid = (L+R)/2;

            if (findRoute(mid)) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean findRoute(int weight) {
        boolean[] visited = new boolean[N+1];
        Queue<Island> q = new LinkedList<>();
        q.offer(new Island(S,0));
        visited[S] = true;

        while(!q.isEmpty()) {
            Island cur = q.poll();

            if (cur.idx == E) {
                return true;
            }

            for (Island next : adj.get(cur.idx)) {
                if (next.idx == cur.idx) continue;
                if (visited[next.idx] || next.weight < weight) continue;
                visited[next.idx] = true;
                q.offer(new Island(next.idx, next.weight));
            }
        }

        return false;
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList<>();
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            adj.get(A).add(new Island(B, C));
            adj.get(B).add(new Island(A, C));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
    }

    static class Island implements Comparable<Island>{
        int idx, weight;

        public Island(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Island l) {
            return l.weight - this.weight;
        }
    }
}