import java.io.*;
import java.util.*;

public class Main {

    private static String S, T;
    private static int Slen;

    public static void main(String[] args) throws IOException {
        input();
        System.out.println(solve(T) ? 1 : 0);
    }

    private static boolean solve(String str) {
        if (str.length() == Slen) {
            return str.equals(S);
        }

        if (str.charAt(str.length() - 1) == 'A') {
            if (solve(str.substring(0, str.length() - 1))) {
                return true;
            }
        }

        if (str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(
                    str.substring(1)
            );

            if (solve(sb.reverse().toString())) {
                return true;
            }
        }
        return false;
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();
        Slen = S.length();
    }
}
