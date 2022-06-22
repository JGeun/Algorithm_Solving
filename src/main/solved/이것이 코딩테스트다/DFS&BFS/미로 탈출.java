import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        for(int i=1; i<=N; i++) {
            String[] line = br.readLine().split("");
            for(int j=1; j<=M; j++) {
                map[i][j] = Integer.parseInt(line[j-1]);
            }
        }

        System.out.println(findExitCount());
    }

    private static int findExitCount() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 1});
        visited[1][1] = true;

        while(!queue.isEmpty()) {
            int[] data = queue.poll();
            if(data[0] == N && data[1] == M) return data[2];
            for(int i=0; i<4; i++) {
                int fx = data[0] + dx[i];
                int fy = data[1] + dy[i];

                if(fx < 1 || fy < 1 || fx > N || fy > M || map[fx][fy] == 0 || visited[fx][fy]) continue;

                visited[fx][fy] = true;
                queue.add(new int[]{fx, fy, data[2]+1});
            }
        }
        return -1;
    }
}