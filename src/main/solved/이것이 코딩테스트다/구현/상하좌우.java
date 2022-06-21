import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static int x = 1, y= 1;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] dirs = br.readLine().split(" ");

        for(String dir : dirs) {
            switch (dir) {
                case "U":
                    if(x == 1) continue;
                    x -= 1;
                    break;
                case "D":
                    if(x == N) continue;
                    x += 1;
                    break;
                case "R":
                    if(y == N) continue;
                    y += 1;
                    break;
                case "L":
                    if(y == 1) continue;
                    y -= 1;
                    break;
            }
        }

        System.out.println(x + " " + y);

    }
}