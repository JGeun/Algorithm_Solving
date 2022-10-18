import java.io.*;
import java.util.*;

class Main {
    private static StringBuilder ansSb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            findZeroCase(N, 1, "");
            if (T >= 1) {
                ansSb.append('\n');
            }
        }
        System.out.print(ansSb.toString());
    }

    private static void findZeroCase(int N, int pos, String input) {
        input += pos;

        if (pos == N) {
            if (calc(input) == 0) {
                ansSb.append(input).append('\n');
            }
            return;
        }

        findZeroCase(N, pos + 1, input + " ");
        findZeroCase(N, pos + 1, input + "+");
        findZeroCase(N, pos + 1, input + "-");
    }

    private static int calc(String input) {
        Deque<String> queue = new LinkedList<>();
        for (int i = 0; i < input.length(); i++) {
            String str = input.substring(i, i+1);
            if (str.equals(" ")) {
                queue.offer(queue.pollLast() + input.charAt(i+1));
                i += 1;
            } else {
                queue.offer(str);
            }
        }

        while (queue.size() != 1) {
            int prev = Integer.parseInt(queue.poll());
            String op = queue.poll();
            int next = Integer.parseInt(queue.poll());

            switch (op) {
                case "+":
                    queue.addFirst(String.valueOf(prev + next));
                    break;
                case "-":
                    queue.addFirst(String.valueOf(prev - next));
                    break;
            }
        }
        return Integer.parseInt(queue.poll());
    }
}