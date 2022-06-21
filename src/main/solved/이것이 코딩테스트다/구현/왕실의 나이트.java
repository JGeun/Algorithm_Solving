import java.util.*;
import java.io.*;

public class Main {
    private static int[][] move = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {2, -1}, {2, 1}, {1, -2}, {1, 2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String knight = br.readLine();
        int x = Character.getNumericValue(knight.charAt(1));
        int y = knight.charAt(0) - 'a' + 1;

        int ans = 0;
        for(int i = 0; i < move.length; i++) {
            int fx = x + move[i][0];
            int fy = y + move[i][1];

            if(fx >= 1 && fy >= 1 && fx <= 8 && fy <= 8) {
                ans += 1;
            }
        }
        System.out.println(ans);
    }
}