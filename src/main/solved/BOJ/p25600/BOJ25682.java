import java.io.*;
import java.util.*;

public class Main {

    private static int M, N, K;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int[][] prefixSumB = prefixSum('W');
        int[][] prefixSumW = prefixSum('B');
        System.out.println(Math.min(calc(prefixSumB), calc(prefixSumW)));
    }

    private static int calc(int[][] prefixSum) {
        int res = Integer.MAX_VALUE;
        for (int i=1; i<=N-K+1; i++) {
            for (int j=1; j<=M-K+1; j++) {
                int num = prefixSum[i+K-1][j+K-1] - prefixSum[i+K-1][j-1] - prefixSum[i-1][j+K-1] + prefixSum[i-1][j-1];
                res = Math.min(res, num);
            }
        }
        return res;
    }

    private static int[][] prefixSum(char ch) {
        int[][] temp = new int[N+1][M+1];
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                int curr = 0;

                if ((i + j) % 2 == 0 && board[i][j] != ch) {
                    curr = 1;
                } else if ((i+j)%2 != 0 && board[i][j] == ch) {
                    curr = 1;
                }

                temp[i+1][j+1] = temp[i+1][j] + temp[i][j+1] - temp[i][j] + curr;
            }
        }

        return temp;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                board[i][j] = line.charAt(j);
            }
        }
    }
}