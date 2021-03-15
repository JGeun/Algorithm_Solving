package BOJ.JGeun.p14800;

import java.util.Scanner;

public class BOJ14889 {
    private static int N;
    private static int[][] arr;
    private static boolean[] visit;
    private static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N][N];
        for(int i=0; i<N; i++)
            for(int j=0; j<N; j++)
                arr[i][j] =  sc.nextInt();
        visit = new boolean[N];
        dfs(0,0);

        System.out.println(min);
    }

    public static void dfs(int pos, int k){
        if(k == N/2){
            getScoreDiff();
            return;
        }

        for(int i=pos; i<N; i++){
            visit[i] = true;
            dfs(i+1, k+1);
            visit[i] = false;
        }

    }

    public static void getScoreDiff(){
        int[] start = new int[N/2];
        int[] link = new int[N/2];
        int startCount = 0;
        int linkCount = 0;
        for(int i=0; i<N; i++) {
            if (visit[i])
                start[startCount++] = i;
            else
                link[linkCount++] = i;
        }
        int startSum = 0, linkSum = 0;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i+1; j < N / 2; j++) {
                startSum += arr[start[i]][start[j]] + arr[start[j]][start[i]];
                linkSum += arr[link[i]][link[j]] + arr[link[j]][link[i]];
            }
        }

        min = Math.min(min, Math.abs(startSum - linkSum));
    }
}
