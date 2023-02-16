import java.util.*;

class Solution {
    private ArrayList<Integer> list = new ArrayList<>();
    private int n, m, cnt = 0;
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] visited;
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        visited = new boolean[n][m];

        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (visited[i][j] || maps[i].charAt(j)=='X') continue;

                cnt = 0;
                checkAdjacentBlock(maps, i, j);
                list.add(cnt);
            }
        }

        if(list.size() == 0) {
            return new int[]{-1};
        }

        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }

    private void checkAdjacentBlock(String[] maps, int x, int y) {
        cnt += maps[x].charAt(y) - '0';
        visited[x][y] = true;

        for (int i=0; i<4; i++) {
            int fx = x + dx[i];
            int fy = y + dy[i];

            if (fx < 0 || fy < 0 || fx >= n || fy >= m) continue;
            if (visited[fx][fy] || maps[fx].charAt(fy) == 'X') continue;

            checkAdjacentBlock(maps, fx, fy);
        }
    }
}