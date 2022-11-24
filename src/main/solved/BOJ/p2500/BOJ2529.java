import java.io.*;
import java.util.*;

public class Main {

    private static int k;
    private static boolean[] visited = new boolean[10];
    private static char[] signs;
    private static String max = "0000000000", min = "9999999999";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());
        signs = new char[k];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<k; i++) {
            signs[i] = st.nextToken().charAt(0);
        }

        findAnswer(new int[k+1], 0);

        System.out.println(max);
        System.out.println(min);
    }

    private static void findAnswer(int[] order, int cnt) {
        if (cnt == k+1) {
            checkValue(order);
            return ;
        }

        for (int i=0; i<10; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order[cnt] = i;
                findAnswer(order, cnt+1);
                visited[i] = false;
            }

        }
    }

    private static void checkValue(int[] order) {

        for (int i=0; i<k; i++) {
            if (signs[i] == '>' && order[i] < order[i+1]) {
                return;
            }
            if (signs[i] == '<' && order[i] > order[i+1]) {
                return;
            }
        }
        calcValue(order);
    }

    private static void calcValue(int[] order) {
        StringBuilder sb = new StringBuilder();
        for(int o : order) {
            sb.append(o);
        }
        String value = sb.toString();
        if (value.compareTo(max) > 0) {
            max = value;
        }
        if (value.compareTo(min) < 0) {
            min = value;
        }
    }
}