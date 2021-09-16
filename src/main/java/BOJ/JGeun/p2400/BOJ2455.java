package BOJ.JGeun.p2400;

import java.io.*;
import java.util.*;

public class BOJ2455 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int[][] station;

    static void input() throws IOException {
        station = new int[4][2];
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            station[i][0] = Integer.parseInt(st.nextToken());
            station[i][1] = Integer.parseInt(st.nextToken());
        }
    }

    static void process(){
        int sum = 0, max = 0;
        for(int i=0; i<4; i++){
            sum = sum + station[i][1] - station[i][0];
            if(max < sum) max = sum;
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
