import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int result = 0;
        for (int i=0; i<str.length(); i++) {
            String subStr = str.substring(i);
            result = Math.max(result, getMaxLength(subStr));
        }
        System.out.println(result);
    }

    private static int getMaxLength(String p) {
        int m = p.length(), j =0, max = 0;
        int[] pi = new int[m];
        for (int i=1; i<m; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j))
                j = pi[j-1];
            if (p.charAt(i) == p.charAt(j)) {
                pi[i] = ++j;
                max = Math.max(max, pi[i]);
            }
        }
        return max;
    }
}