package BOJ.p1900;

import java.io.*;
import java.util.*;

public class BOJ1949_dp {
    private static int N;
    private static ArrayList<Integer>[] nodes;
    private static int[] town;
    private static int[][] dp;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        town = new int[N+1];
        dp = new int[N+1][2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) town[i] = Integer.parseInt(st.nextToken());

        nodes = new ArrayList[N+1];
        for(int i=1; i<=N; i++) nodes[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes[a].add(b);
            nodes[b].add(a);
        }

        dfs(1, 0);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }

    private static void dfs(int idx, int parent){ //0은 선택X, 1은 선택

        for(int child : nodes[idx]){
            if(child != parent){ //단반향 트리가 아니기 때문에 parent와 같으면 제외
                dfs(child, idx);
                dp[idx][0] += Math.max(dp[child][0], dp[child][1]);
                dp[idx][1] += dp[child][0];
            }
        }

        dp[idx][1] += town[idx];
    }
}
