import java.util.*;

class Solution {
    private final int INF = 20000001;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] dist = new int[n+1][n+1];

        for (int i=1; i<=n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int[] fare : fares) {
            dist[fare[0]][fare[1]] = fare[2];
            dist[fare[1]][fare[0]] = fare[2];
        }

        for (int i=1; i<=n; i++) {
            dist[i][i] = 0;
        }

        for (int k=1; k<=n; k++) {
            for (int i=1; i<=n; i++) {
                for (int j=1; j<=n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        int ans = INF;
        for (int i=1; i<=n; i++) {
            ans = Math.min(ans, dist[s][i] + dist[i][a] + dist[i][b]);
        }
        return ans;
    }
}