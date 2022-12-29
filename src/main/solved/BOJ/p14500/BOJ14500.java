import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] map;
    private static int[][][] blockCase = new int[][][]{
            {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 네모 블럭
            {{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // l블록 가로배치
            {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // l블록 세로 배치
            {{0, 0}, {0, 1}, {0, 2}, {1, 1}}, // ㅜ블록 배치
            {{0, 0}, {0, 1}, {0, 2}, {-1, 1}}, // ㅗ블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {1, 1}}, // ㅏ블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {1, -1}}, // ㅓ블록 배치
            {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 4번째 블록 정배치
            {{0, 0}, {1, 0}, {1, -1}, {2, -1}}, // 4번째 블록 정배치 대칭
            {{0, 0}, {0, -1}, {1, -1}, {1, -2}}, // 4번째 블록 우측 1회전
            {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // 4번째 블록 우측 1회전 대칭
            {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // L블록 배치
            {{0, 0}, {1, 0}, {2, 0}, {2, -1}}, // L블록 대칭 배치
            {{0, 0}, {1, 0}, {0, 1}, {0, 2}}, // ㄱ블록(가로 긴 버전) 대칭 배치
            {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // ㄱ블록(가로 긴 버전) 배치
            {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // ㄱ블룩(세로 긴 버전) 배치
            {{0, 0}, {0, 1}, {1, 0}, {2, 0}}, // ㄱ블록(세로 긴 버전) 대칭 배치
            {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // ㄴ블록 배치
            {{1, 0}, {1, 1}, {1, 2}, {0, 2}} // ㄴ블록 대칭 배치
    };

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int ans = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < blockCase.length; k++) {
                    int sum = 0;
                    boolean isBlock = true;
                    for (int t = 0; t < 4; t++) {
                        int bx = i + blockCase[k][t][0]; // 체크하고자 하는 블록의 x
                        int by = j + blockCase[k][t][1]; // 체크하고자 하는 블록의 y

                        if (bx < 0 || by < 0 || bx >= N || by >= M) {
                            isBlock = false;
                            break;
                        }

                        sum += map[bx][by];
                    }

                    if (!isBlock) continue;

                    ans = Math.max(ans, sum);
                }
            }
        }

        System.out.println(ans);
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}