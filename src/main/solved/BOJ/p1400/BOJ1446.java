import java.io.*;
import java.util.*;

class Main {

    private static int N, D;
    private static ArrayList<Road> roadList;
    private static int[] dist;
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        dist = new int[10001];
        Arrays.fill(dist, 10001);
        dist[0] = 0;
        int idx = 0, move = 0;

        while(move < D) {
            if (idx < roadList.size()) {
                Road road = roadList.get(idx);

                // 현재 위치와 S가 같을 경우
                if (move == road.S) {
                    dist[road.E] = Math.min(dist[move] + road.W, dist[road.E]);
                    idx+=1;
                } else { // 같지 않다면 그냥 이동
                    dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                    move+=1;
                }
            } else { // roadList가 없을 경우 종착지까지 +1
                dist[move+1] = Math.min(dist[move+1], dist[move]+1);
                move+=1;
            }
        }
        System.out.println(dist[D]);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        roadList = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if (e > D) continue;
            if (e - s <= w) continue;
            roadList.add(new Road(s, e, w));
        }

        Collections.sort(roadList, (r1, r2) -> {
            if (r1.S != r2.S) return r1.S - r2.S;
            return r1.E - r2.E;
        });
    }

    static class Road {
        int S, E, W;

        public Road(int S, int E, int W) {
            this.S = S;
            this.E = E;
            this.W = W;
        }
    }
}