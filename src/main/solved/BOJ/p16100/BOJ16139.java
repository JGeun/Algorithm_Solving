import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        int[][] sum = new int[str.length()+1][26];

        for (int i=0; i<str.length(); i++) {
            int idx = str.charAt(i)-'a';
            for(int j=0; j<26; j++) {
                sum[i+1][j] = sum[i][j];
            }
            sum[i+1][idx] += 1;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i=0; i<q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = st.nextToken().charAt(0)-'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(sum[end+1][idx] - sum[start][idx]).append('\n');
        }
        System.out.print(sb.toString());
    }
}