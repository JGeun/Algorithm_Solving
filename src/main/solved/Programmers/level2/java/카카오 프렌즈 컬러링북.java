import java.util.*;

class Solution {
    private int[] dx = {-1, 1, 0, 0};
    private int[] dy = {0, 0, -1, 1};
    private boolean[][] visited;
    private int areaSize = 0;

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        visited = new boolean[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    int areaSize = findSameArea(m, n, picture, i, j);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, areaSize);
                    numberOfArea += 1;
                }

            }
        }

        return new int[]{ numberOfArea, maxSizeOfOneArea };
    }

    private int findSameArea(int m, int n, int[][] picture, int x, int y) {
        int areaSize = 1;

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{x, y});

        visited[x][y] = true;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i=0; i<4; i++) {
                int fx = pos[0] + dx[i];
                int fy = pos[1] + dy[i];

                if(fx >= 0 && fy >= 0 && fx < m && fy < n && !visited[fx][fy] && picture[fx][fy] == picture[pos[0]][pos[1]]) {
                    visited[fx][fy] = true;
                    queue.add(new int[]{fx, fy});
                    areaSize += 1;
                }
            }
        }
        return areaSize;
    }
}