import java.io.*;
import java.util.*;

class BOJ13023 {
    private static int N, M, ans = 0;
    private static ArrayList<ArrayList<Integer>> list;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(new ArrayList<>());
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        for (int i = 0; i < N; i++) {
            if(ans != 1) findDepth(i, 1);
        }

        System.out.println(ans);
    }

    private static void findDepth(int start, int depth) {
        if(depth == 5) {
            ans = 1;
            return ;
        }

        visited[start] = true;
        for(int n : list.get(start)) {
            if(visited[n]) continue;
            findDepth(n, depth+1);
        }
        visited[start] = false;
    }
}