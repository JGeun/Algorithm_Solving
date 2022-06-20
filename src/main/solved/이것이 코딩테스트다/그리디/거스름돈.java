import java.util.*;
import java.io.*;

public class Main {
    private static int[] coin_type = {500, 100, 50, 10};
    private static int N, ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(int i = 0; i < coin_type.length; i++) {
            if(N == 0) break;

            ans += N / coin_type[i];
            N %= coin_type[i];
        }

        System.out.println(ans);
    }
}
