import java.io.*;
import java.util.*;

// 이 문제는 연결된 node를 adj에 저장해주고 1번부터 dfs를 통해 탐색하면 됩니다.
// 탐색된 노드의 idx는 visited 배열에 순서를 저장합니다.
// 핵심은 오름차순으로 방문해야하기에 adj 저장이 완료된 후 반복문을 통해 sort해줘야 한다.
public class Main {

    private static int N, M, R, order = 1;
    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] visited;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=N; i++) {
            sb.append(visited[i]).append('\n');
        }
        System.out.print(sb.toString());
    }

    private static void dfs(int r) {

        visited[r] = order;
        order += 1;

        ArrayList<Integer> pq = adj.get(r);
        for (int idx : pq) {
            if (visited[idx] != 0) continue;
            dfs(idx);
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i< M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        for (int i=0; i<=N; i++) {
            Collections.sort(adj.get(i));
        }
    }
}