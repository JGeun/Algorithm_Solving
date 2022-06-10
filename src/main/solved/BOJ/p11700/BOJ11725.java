import java.util.*;
import java.io.*;

class BOJ11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N;
    static ArrayList<Integer>[] adj;
    static int[] answer;
    static boolean[] visit;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        adj = new ArrayList[N+1];
        for(int i=1; i<=N; i++) adj[i] = new ArrayList<>();
        answer = new int[N+1];
        visit = new boolean[N + 1];

        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj[x].add(y);
            adj[y].add(x);
        }
    }

    static void dfs(int vertex) {
        visit[vertex] = true;

        for(int i=0; i<adj[vertex].size(); i++){
            int node = adj[vertex].get(i);
            if(visit[node]) continue;
            answer[node] = vertex;
            dfs(node);
        }
    }

    static void process() {
        visit[1] = true;
        dfs(1);

        for(int i=2; i<=N; i++){
            sb.append(answer[i]);
            if(i!=N) sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
