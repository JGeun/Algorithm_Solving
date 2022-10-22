import java.util.*;
import java.io.*;

class Main {
    private static int N, M, ans = -1;
    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<M; j++) {
                board[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        for(int i=0; i<N; ++i){ // 행 시작 부분 제한
            for(int j=0; j<M; ++j){ // 열 시작 부분 제한

                // 제한된 범위인 i x j를 파라미터로 메서드 호출
                findCase(i, j);
            }
        }
        System.out.println(ans);
    }

    private static void findCase(int r, int c) {
        for (int i=-N; i<=N; ++i) {
            for (int j=-M; j<=M; ++j) {

                // 둘 다 움직이지 않을 때
                if(i == 0 && j == 0) continue;

                int x = r;
                int y = c;

                int sqr = 0;

                while (0 <= x && x < N && 0 <= y && y < M) {
                    sqr = sqr *10 + board[x][y];

                    // 제곱근 구하기
                    int root = (int)Math.sqrt(sqr);

                    // 제곱수 판별
                    if( Math.pow(root, 2) == sqr)
                        ans = Math.max(ans, sqr);

                    x += i;
                    y += j;
                }

            }
        }
    }
}