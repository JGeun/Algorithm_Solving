package BOJ.p9000;

import java.io.*;
import java.util.*;

public class BOJ9019 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int A, B;
    static String[] order;
    static boolean[] visited;

    private static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        order = new String[10000];
        visited = new boolean[10000];

        Arrays.fill(order, "");
    }

    static void process() {
        Queue<Integer> q = new LinkedList<>();
        q.add(A);
        visited[A] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            if (num == B) {
                sb.append(order[num]).append('\n');
                break;
            }
            int D = (num*2)%10000;
            int S = num == 0 ? 9999 : num-1;
            int L = num/1000 + (num%1000)*10;
            int R = (num%10)*1000 + num/10;

            if (!visited[D]) {
                q.add(D);
                visited[D] = true;
                order[D] = order[num] + "D";
            }
            if (!visited[S]) {
                q.add(S);
                visited[S] = true;
                order[S] = order[num] + "S";
            }
            if (!visited[L]) {
                q.add(L);
                visited[L] = true;
                order[L] = order[num] + "L";
            }
            if (!visited[R]) {
                q.add(R);
                visited[R] = true;
                order[R] = order[num] + "R";
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            input();
            process();
        }
        System.out.print(sb.toString());
    }
}
