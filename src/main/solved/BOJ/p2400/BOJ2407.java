import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {
    private static int n, m;

    public static void main(String[] args) throws IOException{
        input();
        solve();
    }

    private static void solve() {
        BigInteger n1 = BigInteger.ONE;
        BigInteger n2 = BigInteger.ONE;

        for (int i=0; i<m; i++) {
            n1 = n1.multiply(new BigInteger(String.valueOf(n - i)));
            n2 = n2.multiply(new BigInteger(String.valueOf(i+1)));
        }

        BigInteger res = n1.divide(n2);
        System.out.println(res);
    }

    private static void input()  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
    }
}