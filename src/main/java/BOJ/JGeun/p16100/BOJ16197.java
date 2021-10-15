package BOJ.JGeun.p16100;

import java.io.*;
import java.util.*;

public class BOJ16197 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st = new StringTokenizer("");
    static StringBuilder sb = new StringBuilder("");

    static int N, M;
    static PriorityQueue<CoinPair> queue = new PriorityQueue<>();
    static char[][] map;
    static Coin[] coins = new Coin[2];
    static int coinIndex = 0;
    static int[] dx = new int[]{-1,1,0,0};
    static int[] dy = new int[]{0,0,-1,1};

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N+2][M+2];
        for(int i=1; i<=N; i++){
            char[] line = br.readLine().toCharArray();
            for(int j=1; j<=line.length; j++){
                map[i][j] = line[j-1];
                if(line[j-1] == 'o'){
                    coins[coinIndex] = new Coin(i, j);
                    coinIndex+=1;
                }
            }
        }
    }

    static void process() {
        System.out.println(findRoute());
    }

    static int findRoute(){
        queue.add(new CoinPair(coins[0], coins[1], 0));

        while(!queue.isEmpty()){
            CoinPair pair = queue.poll();
            Coin c1 = pair.c1;
            Coin c2 = pair.c2;

            if(pair.cnt > 10) return -1;

            for(int i=0; i<4; i++){
                int fx1 = c1.x+dx[i];
                int fy1 = c1.y+dy[i];
                int fx2 = c2.x+dx[i];
                int fy2 = c2.y+dy[i];

                if(isFall(fx1, fy1) && isFall(fx2, fy2)) continue;
                if(map[fx1][fy1] == '#'){
                    fx1 = c1.x;
                    fy1 = c1.y;
                }
                if(map[fx2][fy2] == '#'){
                    fx2 = c2.x;
                    fy2 = c2.y;
                }

                if( (!isFall(fx1, fy1) && isFall(fx2, fy2)) || (isFall(fx1, fy1) && !isFall(fx2, fy2))){
                    if(pair.cnt+1 > 10) return -1;
                    return pair.cnt+1;
                }
                queue.add(new CoinPair(new Coin(fx1, fy1), new Coin(fx2, fy2), pair.cnt+1));
            }
        }

        return -1;
    }

    static boolean isFall(int x, int y){
        return !(x > 0 && y>0 && x<=N && y<=M);
    }

    public static void main(String[] args) throws IOException {
        input();
        process();
    }

    static class Coin{
        int x, y;
        Coin(int _x, int _y){
            this.x = _x; this.y = _y;
        }
    }
    static class CoinPair implements Comparable<CoinPair>{
        Coin c1, c2;
        int cnt;
        CoinPair(Coin c1, Coin c2, int cnt){
            this.c1 = c1; this.c2 = c2; this.cnt=cnt;
        }

        @Override
        public int compareTo(CoinPair c) {
            return this.cnt - c.cnt;
        }
    }
}
