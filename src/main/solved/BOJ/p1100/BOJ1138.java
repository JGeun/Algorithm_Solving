import java.io.*;
import java.util.*;

public class Main {

    private static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] order = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=N-1; i>=0; i--) {
            list.add(order[i], i+1);
        }

        list.forEach( a ->
                System.out.print(a + " ")
        );

    }
}