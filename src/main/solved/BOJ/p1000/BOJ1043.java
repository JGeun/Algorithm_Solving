import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] parent;
    private static boolean[] knowArr;
    private static List<List<Integer>> parties = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        // parent[i] != i 인 경우 진실을 알고 있다.
        boolean[] visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            if (!knowArr[i] || visited[i]) continue;
            int root = find(i);

            for (int j = 1; j <= N; j++) {
                if (root != find(j)) continue;

                knowArr[j] = true;
                visited[j] = true;
            }
        }

        //파티에 진실을 아는 사람이 있는지 체크
        boolean[] partyLieCheck = new boolean[M];
        Arrays.fill(partyLieCheck, true);

        for (int i = 0; i < M; i++) {
            for (int j = 1; j <= N; j++) {
                if (!knowArr[j]) continue;
                if (!parties.get(i).contains(j)) continue;
                partyLieCheck[i] = false;
            }
        }

        // 전체 순회하면서 거짓을 들은 파티 체크
        int ans = 0;
        for (int i = 0; i < M; i++) {
            if (!partyLieCheck[i]) continue;
            ans += 1;
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 아는 사람들
        knowArr = new boolean[N + 1];
        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        for (int i = 0; i < size; i++) {
            knowArr[Integer.parseInt(st.nextToken())] = true;
        }

        // 파티 목록 저장
        for (int i = 0; i < M; i++) parties.add(new ArrayList<>());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            size = Integer.parseInt(st.nextToken());
            for (int j = 0; j < size; j++) {
                parties.get(i).add(Integer.parseInt(st.nextToken()));

                //같이 파티에 참가한 사람들 연결
                if (j == 0) continue;
                int nowIdx = parties.get(i).get(j);
                int prevIdx = parties.get(i).get(j - 1);

                union(prevIdx, nowIdx);
            }
        }
    }

    private static int find(int x) {
        if (parent[x] == x) return x;
        return find(parent[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x); //x의 부모노드 찾기
        y = find(y); //y의 부모노드 찾기

        // 이미 같은 그래프에 속해있을 때 false 반환
        if (x == y) return false;

        if (x <= y) parent[y] = x;
        else parent[x] = y;
        return true;
    }
}