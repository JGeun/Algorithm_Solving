package BOJ.p14500;

import java.io.*;
import java.util.*;

public class BOJ14501_backtracking {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N, ans = 0;
    private static int[] T, P;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        T = new int[N+1];
        P = new int[N+1];
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        findMaxPayCase(1, 0, new boolean[N+6]);
        System.out.println(ans);
    }

    private static void findMaxPayCase(int pos, int sum, boolean[] visited) {
        if(pos >= N+1){
            ans = Math.max(ans, sum);
            return;
        }

        if(!isInSchedule(pos, visited)){
            if(pos+T[pos] <= N+1){
                for(int i=pos; i<pos+T[pos]; i++)
                    visited[i] = true;
                findMaxPayCase(pos+T[pos], sum+P[pos], visited);
            }

            for(int i=pos; i<pos+T[pos]; i++)
                visited[i] = false;
            findMaxPayCase(pos+1, sum, visited);
        }
    }

    private static boolean isInSchedule(int pos, boolean[] visited){
        for(int i=pos; i<pos+T[pos]; i++) if(visited[i]) return true;
        return false;
    }
}

