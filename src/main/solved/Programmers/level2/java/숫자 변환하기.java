import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        if (x > y) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, 0});
        boolean[] visited = new boolean[y+1];
        visited[x] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[0] == y) {
                return cur[1];
            }

            if (cur[0]+n <= y && !visited[cur[0]+n]) {
                visited[x+n] = true;
                queue.add(new int[]{cur[0]+n, cur[1]+1});
            }

            if (cur[0]*2 <= y && !visited[cur[0]*2]) {
                visited[cur[0]*2] = true;
                queue.add(new int[]{cur[0]*2, cur[1]+1});
            }

            if (cur[0]*3 <= y && !visited[cur[0]*3]) {
                visited[cur[0]*3] = true;
                queue.add(new int[]{cur[0]*3, cur[1]+1});
            }
        }

        return -1;
    }
}