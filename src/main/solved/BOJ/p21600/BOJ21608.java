import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 이 문제는 학생의 번호별로 좋아하는 학생의 번호를 HashSet으로 저장해놓고
// 규칙에 따라 구현해야하는 문제입니다.
public class Main {
    private static int N;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int[][] map;

    private static Queue<Integer> keyQueue;
    private static ArrayList<HashSet<Integer>> favoList;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {

        while (!keyQueue.isEmpty()) {
            int key = keyQueue.poll();
            ArrayList<int[]> fcl = findFirstCase(key);
            if (fcl.size() == 1) {
                map[fcl.get(0)[0]][fcl.get(0)[1]] = key;
                continue;
            }

            ArrayList<int[]> scl = findSecondCase(fcl);
            map[scl.get(0)[0]][scl.get(0)[1]] = key;


        }

        System.out.println(calcRes());
    }

    private static void printList(ArrayList<int[]> list) {
        for (int[] pos : list) {
            System.out.println(pos[0] + " " + pos[1]);
        }
        System.out.println("---------");
    }

    private static int calcRes() {
        int res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                int cnt = 0;

                HashSet<Integer> favoSet = favoList.get(map[i][j]);

                for (int k = 0; k < 4; k++) {

                    int fx = i + dx[k];
                    int fy = j + dy[k];

                    if (outOfRange(fx, fy)) continue;

                    if (!favoSet.contains(map[fx][fy])) continue;
                    cnt += 1;
                }

                if (cnt == 1) res += 1;
                else if (cnt == 2) res += 10;
                else if (cnt == 3) res += 100;
                else if (cnt == 4) res += 1000;
            }
        }
        return res;
    }

    private static ArrayList<int[]> findSecondCase(ArrayList<int[]> fcl) {
        ArrayList<int[]> scl = new ArrayList<>();
        int[] countArr = new int[fcl.size()];

        for (int j = 0; j < fcl.size(); j++) {
            int[] pos = fcl.get(j);
            int cnt = 0;

            for (int i = 0; i < 4; i++) {
                int fx = pos[0] + dx[i];
                int fy = pos[1] + dy[i];

                if (outOfRange(fx, fy)) continue;

                if (map[fx][fy] != 0) continue;
                cnt += 1;
            }

            countArr[j] = cnt;
        }

        int max = countArr[0];
        for (int i = 1; i < countArr.length; i++) {
            max = Math.max(countArr[i], max);
        }

        for (int i = 0; i < countArr.length; i++) {
            if (max != countArr[i]) continue;

            scl.add(new int[]{fcl.get(i)[0], fcl.get(i)[1]});
        }

        return scl;
    }

    private static ArrayList<int[]> findFirstCase(int key) {
        ArrayList<int[]> caseList = new ArrayList<>();
        int[][] temp = new int[N + 1][N + 1];

        HashSet<Integer> favoSet = favoList.get(key);

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                // 해당 칸이 이미 차있는 경우
                if (map[i][j] != 0) continue;

                for (int k = 0; k < 4; k++) {
                    int fx = i + dx[k];
                    int fy = j + dy[k];

                    if (outOfRange(fx, fy)) continue;
                    // 옆자리 칸이 비어있는 경우 체크X
                    if (map[fx][fy] == 0) continue;

                    if (favoSet.contains(map[fx][fy])) {
                        temp[i][j] += 1;
                    }
                }
            }
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                pq.add(temp[i][j]);
            }
        }

        int max = pq.isEmpty() ? 0 : pq.poll();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (map[i][j] != 0) continue;
                if (temp[i][j] != max) continue;

                caseList.add(new int[]{i, j});
            }
        }

        return caseList;
    }

    private static boolean outOfRange(int fx, int fy) {
        return fx <= 0 || fy <= 0 || fx > N || fy > N;
    }

    private static int[][] cloneMap(int[][] map) {
        int[][] tempMap = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        return tempMap;
    }

    private static void printMap(int[][] map) {
        System.out.println(map.length + " " + N);
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        keyQueue = new LinkedList<>();
        favoList = new ArrayList<>();
        for (int i = 0; i <= N * N; i++) {
            favoList.add(new HashSet<>());
        }

        for (int i = 1; i <= N * N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int key = Integer.parseInt(st.nextToken());
            keyQueue.add(key);
            for (int j = 0; j < 4; j++) {
                favoList.get(key).add(Integer.parseInt(st.nextToken()));
            }
        }
    }
}