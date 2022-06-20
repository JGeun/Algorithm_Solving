import java.util.*;
import java.io.*;

public class Main {
    private static int N, K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int ans = 0;
        while (N != 1) {
            if (N % K == 0) N /= K;
            else N -= 1;

            ans += 1;
        }

        System.out.println(ans);
    }
}