import java.util.*;
import java.io.*;

public class BOJ4179 {
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static char[][] map;
    private static int R, C;
    private static Point jihun, fire;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for(int i=0; i<R; i++) {
            char[] chars = br.readLine().toCharArray();
            for(int j=0; j<C; j++) {
                map[i][j] = chars[j];
                if(map[i][j] == 'J') {
                    jihun = new Point(i, j, 0, 0);
                }else if(map[i][j] == 'F') {
                    fire = new Point(i, j, 1, 0);
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        if(fire != null) queue.add(fire);
        queue.add(jihun);

        while(!queue.isEmpty()) {
            Point p = queue.poll();

            if(isEdge(p.x, p.y) && p.type == 0) {
                System.out.println(p.count + 1);
                return ;
            }

            for(int i = 0; i < 4; i++) {
                int fx = p.x + dx[i];
                int fy = p.y + dy[i];

                if(isRange(fx, fy) && map[fx][fy] != '#' && map[fx][fy] != 'F') {
                    if(p.type == 1) {
                        queue.add(new Point(fx, fy, p.type, p.count + 1));
                        map[fx][fy] = 'F';
                    } else {
                        queue.add(new Point(fx, fy, p.type, p.count + 1));
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }

    private static boolean isRange(int x, int y) {
        if(x >=0 && y>=0 && x < R && y < C)
            return true;
        return false;
    }

    private static boolean isEdge(int x, int y) {
        if(x == 0 || y == 0 || x == R-1 || y == C-1)
            return true;
        return false;
    }

    static class Point {
        int x, y, type, count;

        public Point(int x, int y, int type, int count) {
            this.x = x;
            this.y = y;
            this.type = type;
            this.count = count;
        }
    }
}