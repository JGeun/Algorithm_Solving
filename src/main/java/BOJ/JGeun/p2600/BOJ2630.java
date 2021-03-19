package BOJ.JGeun.p2600;

import java.util.Scanner;

public class BOJ2630 {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        //Å×½ºÆ®
        cutPaper(0, 0, N);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void cutPaper(int y, int x, int n) {
        n /= 2;
        if (n == 1) {
            for(int i=0; i<2; i++){
                for(int j=0; j<2; j++){
                    if (map[y+i][x+j] == 1)
                        blue += 1;
                    else
                        white += 1;
                }
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int color = getWhatColor(y + n * i, x + n * j, n);
                if (color == 1) {
                    blue += 1;
                } else if (color == 0) {
                    white += 1;
                } else {
                    cutPaper(y + n * i, x + n * j, n);
                }
            }
        }
    }

    public static int getWhatColor(int y, int x, int n) {
        int color;
        if (map[y][x] == 1)
            color = 1;
        else
            color = 0;

        for (int i = y; i < y + n; i++) {
            for (int j = x; j < x + n; j++) {
                if (color != map[i][j])
                    return -1;
            }
        }
        return color;
    }
}
