import java.io.*;
import java.util.*;

public class Main {

    private static int answer = 0;
    private static int[] nums;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        findMaxValue(nums, 0, N, new int[N], new boolean[N]);
        System.out.println(answer);
    }

    private static void findMaxValue(int[] nums, int cnt, int N, int[] order, boolean[] visited) {
        if (cnt == N) {
            answer = Math.max(answer, calcValue(order));
            return ;
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = nums[i];
                findMaxValue(nums, cnt+1, N, order, visited);
                visited[i] = false;
            }
        }
    }

    private static int calcValue(int[] order) {
        int sum = 0;
        for (int i=0; i<order.length-1; i++) {
            sum += Math.abs(order[i]-order[i+1]);
        }
        return sum;
    }
}