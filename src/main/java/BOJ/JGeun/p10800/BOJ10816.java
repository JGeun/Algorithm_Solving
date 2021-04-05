package BOJ.JGeun.p10800;

import java.io.*;
import java.util.*;

public class BOJ10816 {
    static final int UPPER_MAX = 10000000;
    static final int MAX_ARRAY = (UPPER_MAX*2) +1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] checkCards = new int[MAX_ARRAY];

        StringTokenizer st  = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <N ; i++) {
            checkCards[Integer.parseInt(st.nextToken()) +UPPER_MAX]++;
        }
        int M = Integer.parseInt(br.readLine());
        st  = new StringTokenizer(br.readLine());
        for (int i = 0; i <M ; i++) {
            sb.append(checkCards[Integer.parseInt(st.nextToken()) + UPPER_MAX]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
