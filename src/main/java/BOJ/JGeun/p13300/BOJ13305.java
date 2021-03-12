package BOJ.JGeun.p13300;

import java.util.Scanner;

public class BOJ13305 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] road = new long[N-1];
        for(int i=0; i<N-1; i++)
            road[i] = sc.nextInt();
        long[] oil = new long[N];
        for(int i=0; i<N; i++)
            oil[i] = sc.nextInt();

        long needOil = 0;
        long min = oil[0];
        for(int i=0; i<oil.length-1; i++){
            if(min > oil[i])
                min = oil[i];
            needOil += min * road[i];
        }

        System.out.println(needOil);
    }
}
