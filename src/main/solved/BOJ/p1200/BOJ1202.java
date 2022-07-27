import java.io.*;
import java.util.*;

public class Main {

    private static int N, K;
    private static Gem[] gems;
    private static int[] bags;

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    private static void process() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && gems[j].weight <= bags[i]) {
                pq.offer(gems[j++].value);
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new Gem[N];

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            gems[i] = new Gem(M, V);
        }

        Arrays.sort(gems, (g1, g2) -> {
            if (g1.weight == g2.weight) return g2.value - g1.value;
            return g1.weight - g2.weight;
        });

        bags = new int[K];
        for (int i=0; i<K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);
    }

    static class Gem{
        int weight, value;

        public Gem(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}