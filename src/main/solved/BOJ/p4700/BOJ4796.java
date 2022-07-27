import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseIdx = 1;

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            if (L == 0 && P == 0 && V == 0) break;

            int result = (V/P)*L + Math.min(V % P, L);
            sb.append("Case ").append(caseIdx).append(": ").append(result).append('\n');
            caseIdx+=1;
        }
        System.out.print(sb);
    }
}