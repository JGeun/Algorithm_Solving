import java.io.*;
import java.util.*;

// 이 문제는 게임 횟수와 이긴 게임이 1씩 더하여 승률을 계산하는 것으로 착각하기 쉽지만 X가 점점 커질수록
// 1로서 체크해야하는 범위가 커지게 된다. 따라서 이분탐색을 통해 접근해주는 것이 올바른 방법이다.
public class Main {

    private static int X, Y;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int ans = -1;
        int L = 1, R = 1000000000;
        while(L <= R) {
            int mid = (L+R)/2;

            if (isChanged(mid)) {
                ans = mid;
                R = mid - 1;
            } else {
                L = mid + 1;
            }
        }

        System.out.println(ans);
    }

    private static boolean isChanged(int game) {
        long prevData = (long)Y*100/X;
        long curData = ((long)Y+game)*100/(X+game);

        return prevData != curData;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
    }
}