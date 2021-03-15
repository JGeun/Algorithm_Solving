package BOJ.JGeun.p14800;

import java.util.Scanner;

public class BOJ14888 {
    private static int N;
    private static int[] arr;
    private static int[] visit;
    private static int max= Integer.MIN_VALUE;
    private static int min= Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        for(int i=0; i<N; i++)
            arr[i] =  sc.nextInt();
        visit = new int[4];
        for(int i=0; i<4; i++)
            visit[i] = sc.nextInt();
        dfs(1, arr[0]);

        System.out.println(max);
        System.out.println(min);
    }

    public static void dfs(int pos, int sum){
        if(pos == N){
            if(max < sum)
                max = sum;
            if(min > sum)
                min = sum;
            return;
        }

        for(int i=0; i<4; i++){
            if(visit[i] != 0) {
                visit[i]-=1;
                if(i == 0)
                    dfs(pos + 1, sum + arr[pos]);
                else if(i == 1)
                    dfs(pos + 1, sum - arr[pos]);
                else if(i == 2)
                    dfs(pos + 1, sum * arr[pos]);
                else
                    dfs(pos + 1, sum / arr[pos]);
                visit[i]+=1;
            }
        }
    }
}
