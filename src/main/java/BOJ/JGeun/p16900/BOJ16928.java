package BOJ.JGeun.p16900;

import java.io.*;
import java.util.*;

public class BOJ16928 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static boolean[] visit = new boolean[101];
    static HashMap<Integer, Integer> events = new HashMap<>();

    private static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            events.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            events.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
    }

    static void process(){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visit[1] = true;

        while(!queue.isEmpty()){
            int[] pos = queue.poll();

            if(pos[0] == 100){
                System.out.println(pos[1]);
                return;
            }

            for(int i=1; i<=6; i++){
                int move = pos[0]+i;
                if(move > 100) break;
                if(visit[move]) continue;

                visit[move] = true;

                if(events.containsKey(move)){
                    int moveto = events.get(move);
                    if(!visit[moveto]) queue.add(new int[]{moveto, pos[1]+1});
                }else{
                    queue.add(new int[]{move, pos[1]+1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }
}
