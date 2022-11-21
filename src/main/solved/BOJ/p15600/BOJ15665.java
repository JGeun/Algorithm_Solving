import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] nums;
    private static LinkedHashSet<String> ans = new LinkedHashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        findSequence(new int[M], 0);
        ans.forEach(System.out::println);
    }

    private static void findSequence(int[] order, int cnt) {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < M; i++) {
                sb.append(order[i]).append(' ');
            }
            ans.add(sb.toString());
            return;
        }

        for (int i = 0; i < N; i++) {
            order[cnt] = nums[i];
            findSequence(order, cnt + 1);
        }
    }
}