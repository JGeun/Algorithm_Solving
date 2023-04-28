import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 왼쪽부터 계란을 들어서 특정 위치의 계란을 친 결과를 백트랙킹 형식으로 관리합니다.
class Main {

    private static int N, ans;
    private static int[] weight, duration;

    public static void main(String[] args) throws IOException {
        input();

        // 가장 왼쪽의 계란을 든다
        solve(0, 0);
        System.out.println(ans);
    }

    private static void solve(int idx, int cnt) {
        if (idx == N) {
            ans = Math.max(ans, cnt);
            return;
        }

        // 손으로 든 계란이 이미 깨졌거나 모든 계란이 이미 깨졌다면
        if (duration[idx] <= 0 || cnt == N-1) {
            solve(idx+1, cnt);
            return;
        }

        int nCnt = cnt;
        for (int i=0; i<N; i++) {
            // 손에 들고있는 계란과 같은 idx라면 패스
            if (i == idx) continue;

            // 부딪히려던 계란이 이미 깨져있다면 통과
            if (duration[i] <= 0) continue;

            hitEgg(idx, i);

            // 부딪혀봤는데 손에 든 계란이 깨지면 cnt ++
            if (duration[idx] <= 0) {
                cnt++;
            }

            // 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
            if (duration[i] <= 0) {
                cnt++;
            }

            // 재귀 호출 -> 다음 계란이 들어옴
            solve(idx+1, cnt);

            // for문의 다음 i를 위해 값을 원상복구
            recoveryEgg(idx, i);
            cnt = nCnt;
        }
    }

    private static void hitEgg(int handEgg, int targetEgg) {
        duration[targetEgg] -= weight[handEgg];
        duration[handEgg] -= weight[targetEgg];
    }

    private static void recoveryEgg(int handEgg, int targetEgg) {
        duration[targetEgg] += weight[handEgg];
        duration[handEgg] += weight[targetEgg];
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        duration = new int[N];
        weight = new int[N];

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            duration[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }
    }
}

// 0, 0
// 1, 2 / 0, 2
// 3, 2 / 1, 2 X
// 4, 1
// 6, 3