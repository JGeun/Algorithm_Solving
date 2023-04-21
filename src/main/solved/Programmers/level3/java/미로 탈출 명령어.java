// 1. 사전 순으로 가장 빠른 경로로 탈출해야 함으로 dir을 알파벳 순서로 정리합니다.
// -> d, l, r u
// 2. 방문을 3차원 배열로 visited[k][n][m] 으로 지정하고 k번째에 n, m 에 방문했는지 체크 합니다.
// 3. bfs를 통해 문자열이 가장 빠른 순서를 찾습니다.
import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";

        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, -1, 1, 0};
        HashMap<Integer, Character> dirAlphaMap = new HashMap<>();
        dirAlphaMap.put(0, 'd');
        dirAlphaMap.put(1, 'l');
        dirAlphaMap.put(2, 'r');
        dirAlphaMap.put(3, 'u');
        boolean[][][] visited = new boolean[k+1][n+1][m+1];

        Queue<Data> q = new LinkedList<>();
        q.offer(new Data(x, y, 0, ""));
        visited[0][x][y] = true;

        while(!q.isEmpty()) {
            Data data = q.poll();

            if (data.k == k && data.x == r && data.y == c) {
                return data.str;
            }

            if (data.k == k) continue;

            for (int i=0; i<4; i++) {
                int fx = data.x + dx[i];
                int fy = data.y + dy[i];

                if (fx <= 0 || fy <= 0 || fx > n || fy > m || visited[data.k+1][fx][fy]) continue;
                visited[data.k+1][fx][fy] = true;
                q.offer(new Data(fx, fy, data.k+1, data.str + dirAlphaMap.get(i)));
            }
        }

        return "impossible";
    }

    class Data {
        int x, y, k;
        String str;

        public Data(int x, int y, int k, String str) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.str = str;
        }
    }
}