import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int h = Integer.parseInt(br.readLine());
        int ans = 0;
        for (int i = 0; i <= h; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if(String.valueOf(i).contains("3") ||  String.valueOf(j).contains("3") || String.valueOf(k).contains("3"))
                        ans += 1;
                }
            }
        }
        System.out.println(ans);
    }
}