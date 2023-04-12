import java.io.*;
import java.util.*;

// 1. N개의 줄로 이뤄진 기차를 배열로 선언 -> 배열크기: 100000 * 20, 명령 체크: 100000 * 20 이기 때문에 시간 OK
// 2. 해당 기차들을 하나의 문자열로 만들고 Set에 저장
// 3. 만약 Set에 있다면 개수에서 제외 Set Size가 정답
class Main {

    private static int N, M, SIZE = 20;
    private static boolean[][] trains;
    private static HashSet<String> trainSet = new HashSet<>();

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<N; i++) {
            sb.delete(0, sb.length());
            for (int j=0; j<SIZE; j++) {
                sb.append(trains[i][j] ? "O" : "X");
            }
            String line = sb.toString();
            if (trainSet.contains(line)) continue;
            trainSet.add(line);
        }

        System.out.println(trainSet.size());
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        trains = new boolean[N][SIZE];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int pos = 0;
            if (order == 1 || order == 2) {
                pos = Integer.parseInt(st.nextToken()) - 1;
            }

            switch (order) {
                case 1:
                    if (trains[idx][pos]) continue;
                    trains[idx][pos] = true;
                    break;
                case 2: {
                    if (!trains[idx][pos]) continue;
                    trains[idx][pos] = false;
                    break;
                }
                case 3:
                    for (int j=SIZE-2; j>=0; j--) {
                        trains[idx][j+1] = trains[idx][j];
                    }
                    trains[idx][0] = false;
                    break;
                case 4:
                    for (int j=1; j<SIZE; j++) {
                        trains[idx][j-1] = trains[idx][j];
                    }
                    trains[idx][SIZE-1] = false;
                    break;
                default:
            }
        }
    }
}