import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private static int[] indeg;
    private static int N, M;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[] semesters = new int[N+1];
        Queue<int[]> queue = new LinkedList<>();

        for (int i=1; i<=N; i++) {
            if(indeg[i] == 0) queue.add(new int[]{i, 1});
        }

        while(!queue.isEmpty()) {
            int[] subject = queue.poll();
            semesters[subject[0]] = subject[1];

            for (int idx : adj.get(subject[0])) {
                indeg[idx] -= 1;
                if (indeg[idx] == 0) {
                    queue.add(new int[]{idx, subject[1]+1});
                }
            }
        }

        for(int i=1; i<semesters.length; i++) {
            System.out.print(semesters[i] + " ");
        }
        System.out.println();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        indeg = new int[N+1];
        for (int i=0; i<=N; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            adj.get(A).add(B);
            indeg[B] += 1;
        }
    }
}