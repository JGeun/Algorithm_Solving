package BOJ.p1900;

import java.io.*;
import java.util.*;

public class BOJ1949_트리순회 {
    private static int N;
    private static ArrayList<Integer>[] nodes;
    private static int[] town;
    private static boolean[] visited;
    private static int[][] check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        town = new int[N+1];
        visited = new boolean[N+1];
        check = new int[N+1][2];
        for(int i=1; i<=N; i++) Arrays.fill(check[i], -1);

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

        System.out.println(Math.max(traversal(1, 0), traversal(1, 1)+town[1]));
    }

    private static int traversal(int idx, int flag) {

        if(check[idx][flag] != -1) return check[idx][flag];

        visited[idx] = true;
        check[idx][flag] = 0;
        for(int child : nodes[idx]){
            if(visited[child]) continue;
            if(flag == 1) check[idx][flag] += traversal(child, 0);
            else check[idx][flag] += Math.max(traversal(child, 1)+town[child], traversal(child, 0));
        }

        visited[idx] = false;
        return check[idx][flag];
    }
}
