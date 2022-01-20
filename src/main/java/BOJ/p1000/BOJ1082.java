package BOJ.p1000;

import java.io.*;
import java.util.*;

public class BOJ1082 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder("");
    static StringTokenizer st;

    static int N, M;
    static ArrayList<Number> list = new ArrayList<>();
    static Number[] P;
    static HashMap<Integer, Integer> costMap = new HashMap<>();

    static void input() throws IOException{
        N = Integer.parseInt(br.readLine());
        P = new Number[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int cost = Integer.parseInt(st.nextToken());
            P[i] = new Number(i, cost);
            costMap.put(i, cost);
        }

        M = Integer.parseInt(br.readLine());
    }

    static void process(){
        Arrays.sort(P, Comparator.comparingInt(P -> P.cost));
        if(P[0].idx == 0){
            if(N == 1 || P[1].cost > M){
                System.out.println(0);
                return;
            }
            list.add(P[1]);
            M -= P[1].cost;
        }

        while(M-P[0].cost >= 0){
            list.add(P[0]);
            M -= P[0].cost;
        }

        for(int i=0; i<list.size(); i++){
            for(int j=N-1; j>list.get(i).idx; j--){
                if(i==0 && j==0) continue;
                int rest = M + list.get(i).cost - costMap.get(j);
                if(rest >= 0){
                    list.set(i, new Number(j, costMap.get(j)));
                    M = rest;
                    break;
                }
            }
            sb.append(list.get(i).idx);
        }

        System.out.print(sb.toString());
    }

    public static void main(String[] args) throws IOException{
        input();
        process();
    }

    static class Number implements Comparable<Number>{
        int idx, cost;

        Number(int idx, int cost){
            this.idx = idx; this.cost = cost;
        }

        @Override
        public int compareTo(Number n){
            return cost - n.cost;
        }
    }
}
