import java.io.*;
import java.util.*;

public class BOJ21938 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static int N, M, ans=0;
    private static double[][] screen;
    private static boolean[][] visited;
    private static int[] dx = new int[]{-1, 1, 0, 0};
    private static int[] dy = new int[]{0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        setScreenPixel();

        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(!visited[i][j] && screen[i][j] != 0){
                    //findSameObjectByBfs(i, j); ans+=1;
                    findSameObjectByDfs(i, j); ans+=1;
                }
            }
        }
        System.out.println(ans);
    }

    //bfs
    private static void findSameObjectByBfs(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()){
            Point p = queue.poll();

            for(int i=0; i<4; i++){
                int fx = p.r + dx[i];
                int fy = p.c + dy[i];

                if(fx >= 0 && fx<N && fy>=0 && fy<M && !visited[fx][fy] && screen[fx][fy] != 0){
                    queue.add(new Point(fx,fy));
                    visited[fx][fy] = true;
                }
            }
        }
    }

    //dfs
    private static void findSameObjectByDfs(int x, int y) {
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int fx = x + dx[i];
            int fy = y + dy[i];

            if(fx >= 0 && fx<N && fy>=0 && fy<M && !visited[fx][fy] && screen[fx][fy] != 0){
                findSameObjectByDfs(fx, fy);
            }
        }
    }

    private static void setScreenPixel() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        screen = new double[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                int r = Integer.parseInt(st.nextToken());
                int g = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                screen[i][j] = (double)(r+g+b)/3;
            }
        }
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(screen[i][j] < T) screen[i][j] = 0;
            }
        }
    }

    static class Point{
        int r, c;
        public Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
