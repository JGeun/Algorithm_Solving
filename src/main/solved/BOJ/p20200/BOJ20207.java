import java.io.*;
import java.util.*;

// 1. 주어진 일정을 정렬한다 (오름차순)
// 2. 제일 작은 값과 큰 값을 저장하며 코팅지가 이어져있을 때까지 체크
// 3. 높이는 해쉬맵에 저장해서 제일 작은 값과 큰값을 for문을 통해 돌면서 찾는다.

import java.util.*;

class Main {

    private static int N;
    private static int[] days = new int[366];

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void solve() {
        int answer = 0;
        int height = 0, width = 0;

        for (int i= 1; i<=365; i++) {
            if (days[i] == 0) {
                answer += height * width;
                width = 0;
                height = 0;
                continue;
            }

            width+=1;
            height = Math.max(height, days[i]);
        }
        answer += width * height;
        System.out.println(answer);
    }


    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            for (int j=s; j<=e; j++) {
                days[j] += 1;
            }
        }
    }
}