import java.util.*;
import java.io.*;

class Main {

    private static int N, K;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    private static void solve() {
        if (K <= N) {
            System.out.println(Math.abs(K-N));
            return;
        }

        int[] visited = new int[K*2];
        Arrays.fill(visited, Integer.MAX_VALUE);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while(!queue.isEmpty()) {
            int value = queue.poll();
            int pos = value;

            while(pos != 0 && pos <= K) {
                if (pos == K) {
                    System.out.println(visited[value]);
                    return;
                }
                pos *= 2;

                if (visited[pos] != Integer.MAX_VALUE) break;
                visited[pos] = visited[value];
                queue.add(pos);
            }

            if (value-1 >= 0 && visited[value-1] == Integer.MAX_VALUE) {
                visited[value-1] = visited[value]+1;
                queue.add(value-1);
            }

            if (value+1 <= K && visited[value+1] == Integer.MAX_VALUE) {
                visited[value+1] = visited[value]+1;
                queue.add(value+1);
            }
        }
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
    }
}