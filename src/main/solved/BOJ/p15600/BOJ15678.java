import java.io.*;
import java.util.*;

class Main {

    private static int N, D;
    private static int[] scores;

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    private static void solve() {
        PriorityQueue<Stone> pq = new PriorityQueue<>();

        long answer = Long.MIN_VALUE;
        for (int i=0; i<scores.length; i++) {
            long stoneVal;
            if(pq.isEmpty() || pq.peek().val < 0) {
                stoneVal = scores[i];
            } else {
                stoneVal = scores[i]+pq.peek().val;
            }
            pq.add(new Stone(i, stoneVal));

            answer = Math.max(answer, pq.peek().val);

            while (!pq.isEmpty() && pq.peek().idx <= i-D) {
                pq.poll();
            }
        }

        System.out.println(answer);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        scores = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static class Stone implements Comparable<Stone> {

        private int idx;
        private long val;

        public Stone(int idx, long val) {
            this.idx = idx;
            this.val = val;
        }

        @Override
        public int compareTo(Stone s) {
            long res = this.val - s.val;
            if (res < 0)return 1;
            else if (res > 0) return -1;
            return 0;
        }
    }
}