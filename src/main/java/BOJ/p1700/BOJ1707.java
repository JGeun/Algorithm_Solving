package BOJ.p1700;

import java.io.*;
import java.util.*;

public class BOJ1707 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder("");

    static int V, E, ans;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> adj;

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        adj = new ArrayList<>();
        visit = new int[V+1];
        for(int i=0; i<=V; i++) adj.add(new ArrayList<>());
        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adj.get(x).add(y);
            adj.get(y).add(x);
        }
    }

    static void process(){
        ans = 0;
        for(int i=1; i<=V; i++){
            if(visit[i] == 0) bfs(i);
        }
        if(ans == -1) sb.append("NO").append('\n');
        else sb.append("YES").append('\n');
    }

    static void bfs(int x){
        Queue<Integer> q =new LinkedList<>();
        visit[x] = 1;
        q.offer(x);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int next : adj.get(node)){
                if(visit[next] == 0){
                    visit[next] = visit[node]+1;
                    q.offer(next);
                }else{
                    if(visit[next]%2 == visit[node]%2){
                        ans = -1;
                        return;
                    }
                }
            }
        }
    }


    public static void main(String[] args) throws IOException{
        int K = Integer.parseInt(br.readLine());
        while(K-->0){
            input();
            process();
        }
        System.out.print(sb);
    }
}
