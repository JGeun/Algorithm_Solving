import java.util.*;
import java.io.*;

public class BOJ16637 {
    private static int ans = Integer.MIN_VALUE;
    private static final ArrayList<Integer> nums = new ArrayList<>();
    private static final ArrayList<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        for(char ch : chars) {
            if(ch == '+' || ch == '-' || ch == '*') ops.add(ch);
            else nums.add(Character.getNumericValue(ch));
        }

        dfs(nums.get(0), 0);
        System.out.println(ans);
    }

    private static void dfs(int result, int idx) {
        if(idx == ops.size()) {
            ans = Math.max(ans, result);
            return;
        }

        int result1 = calc(ops.get(idx), result, nums.get(idx+1));
        dfs(result1, idx+1);

        if(idx+1 < ops.size()) {
            int result2 = calc(ops.get(idx+1), nums.get(idx+1), nums.get(idx+2));
            dfs(calc(ops.get(idx), result, result2), idx + 2);
        }
    }

    private static int calc(char op, int n1, int n2) {
        switch (op) {
            case '+':
                return n1 + n2;
            case '-':
                return n1 - n2;
            case '*':
                return n1 * n2;
            default:
                return -1;
        }
    }
}
