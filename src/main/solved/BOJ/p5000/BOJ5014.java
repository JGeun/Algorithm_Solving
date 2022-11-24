import java.io.*;
import java.util.*;

/**
 * <접근 방법>
 * 탐욕법으로 접근할 수 없고 최솟값을 찾아야 함으로 BFS로 접근했습니다.
 * 기존에 방문했던 층이라면 탐색할 필요가 없기에 visited 변수로 처리했습니다.
 */
public class Main {

    private static int F, G, S, U, D;
    private static int ans = -1;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        F = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        G = Integer.parseInt(input[2]);
        U = Integer.parseInt(input[3]);
        D = Integer.parseInt(input[4]);
        visited = new boolean[F+1];



        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});

        while(!q.isEmpty()) {
            int[] pos = q.poll();

            if (pos[0] == G) {
                ans = pos[1];
                break;
            }
            if (pos[0] - D >= 1 && !visited[pos[0]-D]) {
                visited[pos[0]-D] = true;
                q.add(new int[] {pos[0]-D, pos[1]+1});
            }

            if (pos[0]+U <= F && !visited[pos[0]+U]) {
                visited[pos[0]+U] = true;
                q.add(new int[] {pos[0]+U, pos[1]+1});
            }
        }

        System.out.println(ans != -1 ? ans : "use the stairs");
    }
}