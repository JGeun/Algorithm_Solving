package BOJ.p15600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ15686 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static int[][] map;
    static ArrayList<Point> house;
    static ArrayList<Point> chicken;
    static int ans = Integer.MAX_VALUE;
    static boolean[] open;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) house.add(new Point(i, j));
                else if (map[i][j] == 2) chicken.add(new Point(i, j));
            }
        }

        open = new boolean[chicken.size()];
    }

    static void process(int start, int cnt) {
        if (cnt == M) {
            int comp = 0;
            for (int i = 0; i < house.size(); i++) {
                int value = Integer.MAX_VALUE;
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        value = Math.min(value, distance);
                    }
                }
                comp += value;
            }
            ans = Math.min(ans, comp);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            process(i + 1, cnt + 1);
            open[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process(0, 0);
        System.out.println(ans);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
